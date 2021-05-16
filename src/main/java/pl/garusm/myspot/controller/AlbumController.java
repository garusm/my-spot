package pl.garusm.myspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.garusm.myspot.service.SpotifyAlbumService;


@Controller
@RequestMapping("/admin/albums")
public class AlbumController {

    private final SpotifyAlbumService spotifyAlbumService;

    public AlbumController(SpotifyAlbumService spotifyAlbumService) {
        this.spotifyAlbumService = spotifyAlbumService;
    }

    @GetMapping("/all")
    public String allAlbums(Model model){
        model.addAttribute("albums", spotifyAlbumService.getAlbums());
        return "album/all";
    }

    @GetMapping(path = "/delete/{id}")
    public String albumDelete(@PathVariable Long id, Model model){
        spotifyAlbumService.deleteAlbum(id);
        return "redirect:/admin/albums/all";
    }
}
