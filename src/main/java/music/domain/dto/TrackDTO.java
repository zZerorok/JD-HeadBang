package music.domain.dto;



public class TrackDTO {
    private String artistName;
    private String trackName;
    private String previewUrl;
    private String primaryGenreName;
    private String collectionId;
    private String releaseDate;

    public TrackDTO(String artistName, String trackName, String previewUrl, String primaryGenreName,
                    String releaseDate, String collectionId) {
        this.artistName = artistName;
        this.trackName = trackName;
        this.previewUrl = previewUrl;
        this.primaryGenreName = primaryGenreName;
        this.releaseDate = releaseDate;
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

    public String getCollectionId() {
        return collectionId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
