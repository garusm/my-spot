package pl.garusm.myspot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.garusm.myspot.entity.FavoriteArtist;
import pl.garusm.myspot.repository.FavoriteArtistRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaFavoriteArtistService implements FavoriteArtistService{

    private final FavoriteArtistRepository favoriteArtistRepository;

    public JpaFavoriteArtistService(FavoriteArtistRepository favoriteArtistRepository) {
        this.favoriteArtistRepository = favoriteArtistRepository;
    }

    @Override
    public void addArtist(FavoriteArtist favoriteArtist) {
        favoriteArtistRepository.save(favoriteArtist);
    }

    @Override
    public List<FavoriteArtist> getArtists() {
        return favoriteArtistRepository.findAll();
    }

    @Override
    public Optional<FavoriteArtist> getArtist(Integer id) {
        return favoriteArtistRepository.findById(id);
    }
}
