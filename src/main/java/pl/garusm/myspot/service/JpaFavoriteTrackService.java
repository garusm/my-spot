package pl.garusm.myspot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.garusm.myspot.entity.FavoriteTrack;
import pl.garusm.myspot.repository.FavoriteTrackRepository;

import java.util.List;

@Repository
@Primary
public class JpaFavoriteTrackService implements FavoriteTrackService{

    private final FavoriteTrackRepository favoriteTrackRepository;

    public JpaFavoriteTrackService(FavoriteTrackRepository favoriteTrackRepository) {
        this.favoriteTrackRepository = favoriteTrackRepository;
    }

    @Override
    public void addTrack(FavoriteTrack favoriteTrack) {
        favoriteTrackRepository.save(favoriteTrack);
    }

    @Override
    public List<FavoriteTrack> getTracks() {
        return favoriteTrackRepository.findAll();
    }
}
