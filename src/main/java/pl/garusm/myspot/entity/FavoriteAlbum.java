package pl.garusm.myspot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class FavoriteAlbum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String favoriteAlbumName;


    public FavoriteAlbum() {
    }

    public FavoriteAlbum(Long id, String favoriteAlbumName) {
        this.id = id;
        this.favoriteAlbumName = favoriteAlbumName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFavoriteAlbumName() {
        return favoriteAlbumName;
    }

    public void setFavoriteAlbumName(String favoriteAlbumName) {
        this.favoriteAlbumName = favoriteAlbumName;
    }
}
