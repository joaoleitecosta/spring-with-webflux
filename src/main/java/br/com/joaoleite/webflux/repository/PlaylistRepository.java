package br.com.joaoleite.webflux.repository;

import br.com.joaoleite.webflux.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {

}
