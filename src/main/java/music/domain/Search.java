package music.domain;

import com.google.gson.*;
import music.domain.dto.AlbumDTO;
import music.domain.dto.TrackDTO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Search {

    /**
     * 검색 요청을 매번할 때 마다 HttpClient 객체가 불필요하게 생성된다. <br>
     * 이런 이유로 멤버변수에 선언 후 재사용할 수 있게 변경함
     */
    private final HttpClient client = HttpClient.newHttpClient();

    /**
     * 노래를 검색해서 10개까지 리스트 반환
     * @param keyword
     * @return TrackList
     */
    public List<TrackDTO> searchTracks(String keyword) {

        String encodedParam;

        try {
            encodedParam = URLEncoder.encode(keyword, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        String url = "https://itunes.apple.com/search?term=" + encodedParam + "&lang=ko_kr&limit=10";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        Gson gson = new Gson();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
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

    /**
     * 앨범 ID 목록으로 앨범 목록 조회
     * @param albumIds 검색할 앨범 ID 목록
     */
    public List<AlbumDTO> find(List<String> albumIds) {
        return albumIds.stream()
                .map(this::searchAlbum)
                .toList();
    }

    /*
     * 앨범 ID로 앨범 정보 조회
     */
    public AlbumDTO searchAlbum(String alBumId) {
        String url = "https://itunes.apple.com/lookup?id=" + alBumId + "&entity=song&lang=ko_kr";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        Gson gson = new Gson();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
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
        return albumDTO;
    }

    /** TOP 50 조회 */
    public List<HashMap<String,String>> searchTop50() {

        String url = "https://rss.applemarketingtools.com/api/v2/kr/music/most-played/50/songs.json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        String response = "";
        Gson gson = new Gson();
        List<TrackDTO> trackList = new ArrayList<>();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
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
            String releaseDate = innerJsonObject.get("releaseDate").getAsString();

            track.put("artistName", artistName);
            track.put("trackName", trackName);
            track.put("releaseDate", releaseDate);

            top50Tracks.add(track);
        }
        return top50Tracks;
    }
}


