package pl.garusm.myspot.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.garusm.myspot.service.SpotifyAlbumService;
import pl.garusm.myspot.service.SpotifyTrackService;

import java.util.ArrayList;
import java.util.LinkedHashMap;

@Controller
public class AdminController {

    private final SpotifyTrackService spotifyTrackService;
    private final SpotifyAlbumService spotifyAlbumService;

    public AdminController(SpotifyTrackService spotifyTrackService, SpotifyAlbumService spotifyAlbumService) {
        this.spotifyTrackService = spotifyTrackService;
        this.spotifyAlbumService = spotifyAlbumService;
    }

    @GetMapping("/spotify/signin")
    public String spotifySignIn(Model model) {

        Object details = ((UsernamePasswordAuthenticationToken)((OAuth2Authentication)((SecurityContextImpl) SecurityContextHolder
                .getContext())
                .getAuthentication())
                .getUserAuthentication())
                .getDetails();

        String email = ((LinkedHashMap)details).values().toArray()[2].toString();
        String name = ((LinkedHashMap)details).values().toArray()[1].toString();
        String image = ((LinkedHashMap) ((ArrayList) ((LinkedHashMap)details).values().toArray()[8])
                .toArray()[0]).get("url").toString();
        String country = ((LinkedHashMap)details).values().toArray()[0].toString();
        String followers = ((LinkedHashMap) ((LinkedHashMap)details).values().toArray()[5]).get("total").toString();
        String account = ((LinkedHashMap)details).values().toArray()[9].toString();
        String profile = ((LinkedHashMap)details).values().toArray()[11].toString();

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("image", image);
        model.addAttribute("country", country);
        model.addAttribute("followers", followers);
        model.addAttribute("account", account);
        model.addAttribute("profile", profile);
        model.addAttribute("last3Tracks", spotifyTrackService.getLast3Tracks());
        model.addAttribute("last3Albums", spotifyAlbumService.getLast3Albums());

        return "dashboard";
    }
}
