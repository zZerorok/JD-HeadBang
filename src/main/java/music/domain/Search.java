package music.domain;

import java.io.*;
import java.net.*;
import java.util.*;
import java.net.http.*;
import com.google.gson.*;
import music.domain.dto.*;

public class Search {

    /*
     * 노래를 검색해 10개까지 리스트로 반환
     */
    public List searchTracks(String keyword) {

        String encodedParam;

        {
            try {
                encodedParam = URLEncoder.encode(keyword, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        String url = "https://itunes.apple.com/search?term=" + encodedParam + "&lang=ko_kr&limit=10";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        Gson gson = new Gson();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");

        List<TrackDTO> trackList = new ArrayList<>();

        for (JsonElement element : resultsArray) {
            TrackDTO track = gson.fromJson(element.getAsJsonObject(), TrackDTO.class);
            trackList.add(track);
        }
        return trackList;

    }

    /*
     * 앨범 ID로 앨범 정보 조회
     * 길이가 1인 albumDTO리스트 반환
     */
    public List<AlbumDTO> searchAlbum(String alBumId) {
        String url = "https://itunes.apple.com/lookup?id=" + alBumId + "&entity=song&lang=ko_kr";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        Gson gson = new Gson();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");
        AlbumDTO albumDTO = gson.fromJson(resultsArray.get(0).getAsJsonObject(), AlbumDTO.class);
        albumDTO.init();

        for (int i = 1; i < resultsArray.size(); i++) {
            TrackDTO trackDTO = gson.fromJson(resultsArray.get(i).getAsJsonObject(), TrackDTO.class);
            albumDTO.addTrack(trackDTO);
        }
        List<AlbumDTO> albumList = Arrays.asList(albumDTO);

        return albumList;
    }

    /*
     * TOP 50 조회
     */
    public List<HashMap<String,String>> searchTop50() {

        String url = "https://rss.applemarketingtools.com/api/v2/kr/music/most-played/50/songs.json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        Gson gson = new Gson();
        List<TrackDTO> trackList = new ArrayList<>();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        List<HashMap<String,String>> top50Tracks = new ArrayList<>();

        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();
        JsonObject feed = jsonObject.getAsJsonObject("feed");
        JsonArray resultsArray = feed.getAsJsonArray("results");
        for (JsonElement element : resultsArray) {
            HashMap<String,String> track = new HashMap<>();
            JsonObject innerJsonObject = element.getAsJsonObject();
            String artistName = innerJsonObject.get("artistName").getAsString();
            String trackName = innerJsonObject.get("name").getAsString();

            track.put("artistName", artistName);
            track.put("trackName", trackName);

            top50Tracks.add(track);
        }
            return top50Tracks;
    }

}


