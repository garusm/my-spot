package pl.garusm.myspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.garusm.myspot.service.SpotifyTrackService;

@Controller
@RequestMapping("/admin/tracks")
public class TrackController {

    private final SpotifyTrackService spotifyTrackService;

    public TrackController(SpotifyTrackService spotifyTrackService) {
        this.spotifyTrackService = spotifyTrackService;
    }

    @GetMapping("/all")
    public String allTracks(Model model){
        model.addAttribute("tracks", spotifyTrackService.getTracks());
        return "track/all";
    }

    @GetMapping(path = "/delete/{id}")
    public String trackDelete(@PathVariable Long id, Model model){
       spotifyTrackService.deleteTrack(id);
        return "redirect:/admin/tracks/all";
    }
}
