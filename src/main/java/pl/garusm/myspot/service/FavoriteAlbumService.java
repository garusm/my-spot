package pl.garusm.myspot.service;

import pl.garusm.myspot.entity.FavoriteAlbum;

import java.util.List;

public interface FavoriteAlbumService {

    void addAlbum(FavoriteAlbum favoriteAlbum);
    List<FavoriteAlbum> getAlbums();
}
