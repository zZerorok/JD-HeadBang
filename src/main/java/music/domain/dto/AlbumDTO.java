package music.domain.dto;

import java.util.*;
import com.google.gson.annotations.*;

public class AlbumDTO {

    private String artistName;
    private String collectionName;
    @SerializedName("collectionPrice")
    private Double collectionPriceUSD;
    private String releaseDate;
    private String collectionId;
    private List<TrackDTO> tackList;
    private int collectionPriceKRW;

    private int quantity;

    public AlbumDTO(String artistName, String collectionName, Double collectionPrice, String releaseDate,
                    String collectionId, List<TrackDTO> tracks) {
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.collectionPriceUSD = collectionPrice;
        this.releaseDate = releaseDate;
        this.collectionId = collectionId;
        this.tackList = tracks;
    }

    public void init() {
        collectionPriceKRW = (int) Math.round(collectionPriceUSD * 1.3) * 1000;

        quantity = (int) (Math.random() * 20);

        releaseDate = releaseDate.substring(0, releaseDate.indexOf("T"));

        if (tackList == null) {
            tackList = new ArrayList<>();
        }
    }


    public void addTrack(TrackDTO track) {
        tackList.add(track);
    }


    // Getters
    public String getArtistName() {
        return artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public double getCollectionPriceUSD() {
        return collectionPriceUSD;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getCollectionId() {
        return collectionId;
    }


    public List<TrackDTO> getTrackTs() {
        return tackList;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCollectionPriceKRW() {
        return collectionPriceKRW;
    }
}

