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
    public List<TrackDTO> searchTracks(String keyword) {

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
     */
    public AlbumDTO searchAlbum(String alBumId) {
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

        return albumDTO;
    }
}

