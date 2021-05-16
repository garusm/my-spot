package pl.garusm.myspot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.garusm.myspot.entity.Album;
import pl.garusm.myspot.repository.AlbumRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaAlbumService implements SpotifyAlbumService {

    private final AlbumRepository albumRepository;

    public JpaAlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public void addAlbum(Album album) {
        albumRepository.save(album);
    }

    @Override
    public Optional<Album> getAlbum(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public void deleteAlbum(Long id) {
        albumRepository.deleteById(id);
    }

    @Override
    public List<Album> getLast3Albums() {
        return albumRepository.findAllByOrderByIdDesc();
    }
}
