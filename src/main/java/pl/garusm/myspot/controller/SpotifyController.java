package pl.garusm.myspot.controller;

import org.springframework.http.*;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.garusm.myspot.entity.Album;
import pl.garusm.myspot.entity.Track;
import pl.garusm.myspot.model.JSONalbum.AlbumsCheck;
import pl.garusm.myspot.model.dto.SpotifyAlbumDto;
import pl.garusm.myspot.model.dto.SpotifyTrackDto;
import pl.garusm.myspot.model.JSONtrack.SpotifyAlbum;
import pl.garusm.myspot.service.SpotifyAlbumService;
import pl.garusm.myspot.service.SpotifyTrackService;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/spotify")
public class SpotifyController {

    private final SpotifyTrackService spotifyTrackService;
    private final SpotifyAlbumService spotifyAlbumService;


    public SpotifyController(SpotifyTrackService spotifyTrackService, SpotifyAlbumService spotifyAlbumService) {
        this.spotifyTrackService = spotifyTrackService;
        this.spotifyAlbumService = spotifyAlbumService;
    }

    @GetMapping("/tracks/{authorName}")
    public String getTracksByAuthor(OAuth2Authentication details,
                                    @PathVariable String authorName,
                                    Model model) throws NullPointerException {

        String jwt = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<SpotifyAlbum> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q="
                        + authorName + "&type=track&market=US&limit=50&offset=1",
                HttpMethod.GET,
                httpEntity,
                SpotifyAlbum.class);

        List<SpotifyTrackDto> spotifyTrackDtos = exchange.getBody().getTracks().getItems().stream()
                .map(item -> new SpotifyTrackDto(item.getAlbum().getImages().get(0).getUrl(),
                        ((String) item.getPreviewUrl()), item.getName(),
                        item.getAlbum().getName(), item.getArtists().get(0).getName()))
                .collect(Collectors.toList());

        model.addAttribute("authorName", authorName);
        model.addAttribute("spotifyTrackDtos", spotifyTrackDtos);

        return "spotify/tracks-search";
    }


    @GetMapping("/albums/{authorName}")
    public String getAlbumsByAuthor(OAuth2Authentication details,
                                    @PathVariable String authorName,
                                    Model model) throws NullPointerException {


        String tokenValue = ((OAuth2AuthenticationDetails)details.getDetails()).getTokenValue();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + tokenValue);
        HttpEntity httpEntity = new HttpEntity(httpHeaders);

        ResponseEntity<AlbumsCheck> exchange = restTemplate.exchange("https://api.spotify.com/v1/search?q="
                        + authorName + "&type=album&market=US&limit=50&offset=1",
                HttpMethod.GET,
                httpEntity,
                AlbumsCheck.class);

        List<SpotifyAlbumDto> spotifyAlbumDtos = exchange.getBody().getAlbums().getItems().stream()
                .map(item -> new SpotifyAlbumDto(item.getImages().get(0).getUrl(),
                        item.getName(), item.getArtists().get(0).getName(), item.getReleaseDate()))
                .collect(Collectors.toList());

        model.addAttribute("authorName", authorName);
        model.addAttribute("spotifyAlbumDtos", spotifyAlbumDtos);

        return "spotify/albums-search";
    }

    @GetMapping("/addtrack")
    public String saveTrack(Model model){
        model.addAttribute("track", new Track());
        return "spotify/tracks-search";
    }

    @PostMapping("/addtrack")
    public String processSaveTrack(@ModelAttribute @RequestBody Track track){
        spotifyTrackService.addTrack(track);
        return "redirect:/admin/tracks/all";
    }

    @GetMapping("/addalbum")
    public String saveAlbum(Model model){
        model.addAttribute("album", new Album());
        return "spotify/albums-search";
    }
    @PostMapping("/addalbum")
    public String processSaveAlbum(@ModelAttribute @RequestBody Album album){
        spotifyAlbumService.addAlbum(album);
        return "redirect:/admin/albums/all";
    }

}
