package pl.garusm.myspot.service;

import pl.garusm.myspot.entity.FavoriteArtist;
import java.util.List;
import java.util.Optional;

public interface FavoriteArtistService {

    void addArtist(FavoriteArtist favoriteArtist);
    List<FavoriteArtist> getArtists();
    Optional<FavoriteArtist> getArtist(Integer id);
}
