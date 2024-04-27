package DTO;

import java.time.*;
import java.util.*;

public class AlbumDTO {

    protected String artistName;
    protected String collectionName;
    protected Double collectionPrice;
    protected LocalDate releaseDate;
    protected String collectionId;
    protected List<TrackDTO> tracks;

    private int purchaseNum;

    public AlbumDTO() {
    }

    public AlbumDTO(String artistName, String collectionName, Double collectionPrice, String releaseDate,
                    String collectionId, List<TrackDTO> tracks,int purchaseNum) {
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.collectionPrice = collectionPrice;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.collectionId = collectionId;
        this.tracks = tracks;
        this.purchaseNum =purchaseNum;
    }

    // Getters
    public String getArtistName() {
        return artistName;
    }

    public int getPurchaseNum() {
        return purchaseNum;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public double getCollectionPrice() {
        return collectionPrice;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public List<TrackDTO> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        return  "가수 이름 : " + artistName + '\'' +
                ", 엘범 가격 : " + collectionPrice +
                ", 노래 목록 : " + tracks;
    }
}
