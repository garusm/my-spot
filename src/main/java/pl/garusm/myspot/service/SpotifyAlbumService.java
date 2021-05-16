package pl.garusm.myspot.service;

import pl.garusm.myspot.entity.Album;

import java.util.List;
import java.util.Optional;

public interface SpotifyAlbumService {

    List<Album> getAlbums();
    void addAlbum(Album album);
    Optional<Album> getAlbum(Long id);
    void deleteAlbum(Long id);
    List<Album> getLast3Albums();
}
