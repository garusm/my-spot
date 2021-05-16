package pl.garusm.myspot.model.dto;


public class SpotifyAlbumDto {

    private String imageUrl;
    private String albumName;
    private String artistName;
    private String dateOfRelease;


    public SpotifyAlbumDto() {
    }

    public SpotifyAlbumDto(String imageUrl, String albumName, String artistName, String dateOfRelease) {
        this.imageUrl = imageUrl;
        this.albumName = albumName;
        this.artistName = artistName;
        this.dateOfRelease = dateOfRelease;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(String dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "{" +
                "imageUrl='" + imageUrl + '\'' +
                ", albumName='" + albumName + '\'' +
                ", artistName='" + artistName + '\'' +
                ", dateOfRelease='" + dateOfRelease + '\'' +
                '}';
    }
}
