package pl.garusm.myspot.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class FavoriteArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String favoriteArtistName;


    public FavoriteArtist() {
    }

    public FavoriteArtist(Integer id, String favoriteArtistName) {
        this.id = id;
        this.favoriteArtistName = favoriteArtistName;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFavoriteArtistName() {
        return favoriteArtistName;
    }

    public void setFavoriteArtistName(String favoriteArtistName) {
        this.favoriteArtistName = favoriteArtistName;
    }

}
