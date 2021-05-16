package pl.garusm.myspot.service;

import pl.garusm.myspot.entity.FavoriteTrack;

import java.util.List;

public interface FavoriteTrackService {

    void addTrack(FavoriteTrack favoriteTrack);
    List<FavoriteTrack> getTracks();
}
