package pl.garusm.myspot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.garusm.myspot.entity.Album;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

    @Query(value = "SELECT * from albums order by id desc limit 3", nativeQuery = true)
    List<Album> findAllByOrderByIdDesc();

}
