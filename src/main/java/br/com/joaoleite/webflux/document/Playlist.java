package br.com.joaoleite.webflux.document;

import br.com.joaoleite.webflux.dto.PlaylistDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Playlist {
    @Id
    private String id;
    private String nome;

    public Playlist(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public  Playlist(){}

    public Playlist(PlaylistDTO playListDTO) {
        this.nome = playListDTO.getNome();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
