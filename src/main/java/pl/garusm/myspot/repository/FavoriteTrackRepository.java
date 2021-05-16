package pl.garusm.myspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.garusm.myspot.entity.FavoriteTrack;

public interface FavoriteTrackRepository extends JpaRepository<FavoriteTrack, Long> {
}
