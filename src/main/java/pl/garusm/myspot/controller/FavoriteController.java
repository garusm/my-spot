package pl.garusm.myspot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.garusm.myspot.entity.FavoriteAlbum;
import pl.garusm.myspot.entity.FavoriteArtist;
import pl.garusm.myspot.entity.FavoriteTrack;
import pl.garusm.myspot.service.FavoriteAlbumService;
import pl.garusm.myspot.service.FavoriteArtistService;
import pl.garusm.myspot.service.FavoriteTrackService;

import javax.validation.Valid;

@Controller
@RequestMapping("/favorite")
public class FavoriteController {

    private final FavoriteArtistService favoriteArtistService;
    private final FavoriteAlbumService favoriteAlbumService;
    private final FavoriteTrackService favoriteTrackService;

    public FavoriteController(FavoriteArtistService favoriteArtistService, FavoriteAlbumService favoriteAlbumService, FavoriteTrackService favoriteTrackService) {
        this.favoriteArtistService = favoriteArtistService;
        this.favoriteAlbumService = favoriteAlbumService;
        this.favoriteTrackService = favoriteTrackService;
    }

    @GetMapping("/track/all")
    public String allTracks(Model model){
        model.addAttribute("allFavTracks", favoriteTrackService.getTracks());
        return "favorite/track/all";
    }

    @GetMapping("/track/add")
    public String addTrackForm(FavoriteTrack favoriteTrack, Model model) throws NumberFormatException{
        model.addAttribute("favoriteTrack", new FavoriteTrack());
        model.addAttribute("favArtist", favoriteArtistService.getArtists());
        model.addAttribute("favAlbum", favoriteAlbumService.getAlbums());
        return "favorite/track/add";
    }

    @PostMapping("/track/add")
    public String processAddTrack(@ModelAttribute @Valid FavoriteTrack favoriteTrack, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "favorite/track/add";
        }else {
            favoriteTrackService.addTrack(favoriteTrack);
            return "redirect:/favorite/track/all";
        }
    }

    @GetMapping("/artist/add")
    public String addArtistForm(FavoriteArtist favoriteArtist, Model model){
        model.addAttribute("favoriteArtist", new FavoriteArtist());
        return "favorite/artist/add";
    }

    @PostMapping("/artist/add")
    public String processAddArtist(@ModelAttribute @Valid FavoriteArtist favoriteArtist, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "favorite/artist/add";
        }else {
            favoriteArtistService.addArtist(favoriteArtist);
            return "redirect:/";
        }
    }

    @GetMapping("/album/add")
    public String addAlbumForm(FavoriteAlbum favoriteAlbum ,Model model){
        model.addAttribute("favoriteAlbum", new FavoriteAlbum());
        return "favorite/album/add";
    }

    @PostMapping("/album/add")
    public String processAddAlbum(@ModelAttribute @Valid FavoriteAlbum favoriteAlbum, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "favorite/album/add";
        }else {
            favoriteAlbumService.addAlbum(favoriteAlbum);
            return "redirect:/";
        }
    }
}
