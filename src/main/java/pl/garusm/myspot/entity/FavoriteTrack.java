package pl.garusm.myspot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class FavoriteTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 50, message = "{trackName.msg}")
    private String favoriteTrackName;

    @NotNull
    @ManyToOne
    private FavoriteArtist favoriteArtist;

    @NotNull
    @ManyToOne
    private FavoriteAlbum favoriteAlbum;

    public FavoriteTrack() {
    }

    public FavoriteTrack(Long id, String favoriteTrackName, FavoriteAlbum favoriteAlbum) {
        this.id = id;
        this.favoriteTrackName = favoriteTrackName;
        this.favoriteAlbum = favoriteAlbum;
    }

    public FavoriteArtist getFavoriteArtist() {
        return favoriteArtist;
    }

    public void setFavoriteArtist(FavoriteArtist favoriteArtist) {
        this.favoriteArtist = favoriteArtist;
    }

    public FavoriteAlbum getFavoriteAlbum() {
        return favoriteAlbum;
    }

    public void setFavoriteAlbum(FavoriteAlbum favoriteAlbum) {
        this.favoriteAlbum = favoriteAlbum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFavoriteTrackName() {
        return favoriteTrackName;
    }

    public void setFavoriteTrackName(String favoriteTrackName) {
        this.favoriteTrackName = favoriteTrackName;
    }
}
