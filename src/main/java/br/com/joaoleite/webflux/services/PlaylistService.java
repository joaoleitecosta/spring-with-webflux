package br.com.joaoleite.webflux.services;

import br.com.joaoleite.webflux.document.Playlist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public interface PlaylistService {

   Flux<Playlist> findAll();
   Mono<Playlist> findById(String id);
   Mono<Playlist> save(Playlist playList);
}
