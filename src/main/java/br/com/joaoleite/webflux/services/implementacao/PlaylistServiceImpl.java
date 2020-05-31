package br.com.joaoleite.webflux.services.implementacao;

import br.com.joaoleite.webflux.document.Playlist;
import br.com.joaoleite.webflux.repository.PlaylistRepository;
import br.com.joaoleite.webflux.services.PlaylistService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    final
    PlaylistRepository repository;

    public PlaylistServiceImpl(PlaylistRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Playlist> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Playlist> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Playlist> save(Playlist playList) {
        return repository.save(playList);
    }
}
