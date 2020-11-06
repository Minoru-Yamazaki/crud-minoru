package br.com.crud.anime.service;

import br.com.crud.anime.dto.AnimeDTO;
import br.com.crud.anime.model.Anime;
import br.com.crud.anime.repository.AnimeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Essa classe vai ser responsavel
 * por fazer toda a logica de crud!
 */
@Slf4j
@Service
public class AnimeService {

    @Autowired
    private AnimeRepository repository;

    public void salvarAnime(AnimeDTO animeDto) {

        Anime anime = convertoAnime(animeDto,new Anime());

        this.repository.save(anime);
    }

    public AnimeDTO buscaAnimePorNome(String nome) {
        Anime anime = this.repository.findByNome(nome)
                                     .orElseThrow(() -> new RuntimeException("Anime não encontrado!"));

        return new AnimeDTO(anime);
    }

    public void atualizarUmAnime(AnimeDTO animeDto) {
        Anime anime = getAnime(animeDto.getId());

        anime = convertoAnime(animeDto, anime);

        this.repository.save(anime);
    }

    private Anime convertoAnime(AnimeDTO animeDto, Anime anime) {

        anime.setNome(animeDto.getNome());
        anime.setGenero(animeDto.getGenero());
        anime.setAnoLancamento(animeDto.getAnoLancamento());

        return anime;
    }

    private Anime getAnime(long id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Anime não existe!"));
    }
}
