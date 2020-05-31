package br.com.joaoleite.webflux.controller;

import br.com.joaoleite.webflux.dto.PlaylistDTO;
import br.com.joaoleite.webflux.document.Playlist;
import br.com.joaoleite.webflux.services.PlaylistService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {

    private final PlaylistService service;

    public PlaylistController(PlaylistService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Playlist> getPlaylist() {
        return  service.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Playlist> getPlaylistId(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Playlist> save(@RequestBody PlaylistDTO playlistDTO) {
        Playlist playlist = new Playlist(playlistDTO);
       return service.save(playlist);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {

        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = service.findAll();
        System.out.println("passei aqui");
        return Flux.zip(interval, events);
    }

}
