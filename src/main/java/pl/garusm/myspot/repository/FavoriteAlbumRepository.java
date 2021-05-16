package pl.garusm.myspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.garusm.myspot.entity.FavoriteAlbum;

public interface FavoriteAlbumRepository extends JpaRepository<FavoriteAlbum, Long> {
}
