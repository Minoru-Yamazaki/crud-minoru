package br.com.crud.anime.dto;

import br.com.crud.anime.model.Anime;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AnimeDTO {

    private long id;
    private String nome;
    private String genero;
    private String anoLancamento;

    public AnimeDTO(Anime anime) {
        this.id = anime.getId();
        this.nome = anime.getNome();
        this.genero = anime.getGenero();
        this.anoLancamento = anime.getAnoLancamento();
    }
}
