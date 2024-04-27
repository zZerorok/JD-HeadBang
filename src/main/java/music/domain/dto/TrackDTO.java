package music.domain.dto;

import java.time.*;

public class TrackDTO {
    protected String artistName;
    protected String trackName;
    protected String previewUrl;
    protected String primaryGenreName;
    protected String collectionId;
    protected LocalDate releaseDate;

    public TrackDTO(String artistName, String trackName, String previewUrl, String primaryGenreName,
                    String releaseDate, String collectionId) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.previewUrl = previewUrl;
        this.primaryGenreName = primaryGenreName;
        this.releaseDate = LocalDate.parse(releaseDate);
        this.collectionId = collectionId;

    }


    // getters
    public String getArtistName() {
        return artistName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return trackName;
    }
}
