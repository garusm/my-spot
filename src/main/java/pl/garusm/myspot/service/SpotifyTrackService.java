package pl.garusm.myspot.service;

import pl.garusm.myspot.entity.Track;

import java.util.List;
import java.util.Optional;

public interface SpotifyTrackService {

    List<Track> getTracks();
    void addTrack(Track track);
    Optional<Track> getTrack(Long id);
    void deleteTrack(Long id);
    List<Track> getLast3Tracks();


}
