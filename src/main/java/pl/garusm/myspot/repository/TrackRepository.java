package pl.garusm.myspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.garusm.myspot.entity.Track;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long> {

    @Query(value = "SELECT * from tracks order by id desc limit 3", nativeQuery = true)
    List<Track> findAllByOrderByIdDesc();

}
