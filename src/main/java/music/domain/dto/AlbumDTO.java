package music.domain.dto;

import java.time.*;
import java.util.*;

public class AlbumDTO {

    protected String artistName;
    protected String collectionName;
    protected Double collectionPrice;
    protected LocalDate releaseDate;
    protected String collectionId;
    protected List<TrackDTO> tracks;



    public AlbumDTO(String artistName, String collectionName, Double collectionPrice, String releaseDate,
                    String collectionId, List<TrackDTO> tracks) {
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.collectionPrice = collectionPrice;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.collectionId = collectionId;
        this.tracks = tracks;
    }

    // Getters
    public String getArtistName() {
        return artistName;
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
        return "앨범 [" +
                "artistName='" + artistName + '\'' +
                ", collectionName='" + collectionName + '\'' +
                ", collectionPrice=" + collectionPrice +
                ", releaseDate=" + releaseDate +
                ", collectionId='" + collectionId + '\'' +
                ", tracks=" + tracks +
                ']';
    }
}

