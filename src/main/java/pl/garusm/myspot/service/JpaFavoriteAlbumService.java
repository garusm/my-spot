package pl.garusm.myspot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.garusm.myspot.entity.FavoriteAlbum;
import pl.garusm.myspot.repository.FavoriteAlbumRepository;

import java.util.List;

@Repository
@Primary
public class JpaFavoriteAlbumService implements FavoriteAlbumService{

    private final FavoriteAlbumRepository favoriteAlbumRepository;

    public JpaFavoriteAlbumService(FavoriteAlbumRepository favoriteAlbumRepository) {
        this.favoriteAlbumRepository = favoriteAlbumRepository;
    }

    @Override
    public void addAlbum(FavoriteAlbum favoriteAlbum) {
        favoriteAlbumRepository.save(favoriteAlbum);
    }

    @Override
    public List<FavoriteAlbum> getAlbums() {
        return favoriteAlbumRepository.findAll();
    }
}
