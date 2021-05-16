package pl.garusm.myspot.model.dto;

public class SpotifyTrackDto {

    private String imageUrl;
    private String previewUrl;
    private String trackName;
    private String albumName;
    private String artistName;

    public SpotifyTrackDto() {
    }

    public SpotifyTrackDto(String imageUrl, String previewUrl, String trackName, String albumName, String artistName) {
        this.imageUrl = imageUrl;
        this.previewUrl = previewUrl;
        this.trackName = trackName;
        this.albumName = albumName;
        this.artistName = artistName;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }
}
