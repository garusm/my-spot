package pl.garusm.myspot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.garusm.myspot.entity.Track;
import pl.garusm.myspot.repository.TrackRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JpaTrackService implements SpotifyTrackService {

    private final TrackRepository trackRepository;

    public JpaTrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> getTracks() {
        return trackRepository.findAll();
    }

    @Override
    public void addTrack(Track track) {
        trackRepository.save(track);
    }

    @Override
    public Optional<Track> getTrack(Long id) {
        return trackRepository.findById(id);
    }

    @Override
    public void deleteTrack(Long id) {
        trackRepository.deleteById(id);
    }

    @Override
    public List<Track> getLast3Tracks() {
        return trackRepository.findAllByOrderByIdDesc();
    }


}
