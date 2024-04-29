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

    public AlbumDTO(String artistName, String collectionName, Double collectionPriceUSD, String releaseDate,
                    String collectionId, List<TrackDTO> tracks) {
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.collectionPriceUSD = collectionPriceUSD;
        this.releaseDate = releaseDate;
        this.collectionId = collectionId;
        this.tackList = tracks;
    }

    public void init() {
        collectionPriceKRW = (int) Math.round(collectionPriceUSD * 1.3) * 1000;

        quantity = (int) (Math.random() * 20); // 0~20

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


    /* 앨범 재고 차감 */
    public void decrementQuantity(int amount) {
        quantity = Math.max(quantity - amount, 0);

    }

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "artistName='" + artistName + '\'' +
                ", collectionName='" + collectionName + '\'' +
                ", collectionPriceUSD=" + collectionPriceUSD +
                ", releaseDate='" + releaseDate + '\'' +
                ", collectionId='" + collectionId + '\'' +
                ", tackList=" + tackList +
                ", collectionPriceKRW=" + collectionPriceKRW +
                ", quantity=" + quantity +
                '}';


    }
}

