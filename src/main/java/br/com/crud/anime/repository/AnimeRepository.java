package br.com.crud.anime.repository;

import br.com.crud.anime.model.Anime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * interface responsavel por salvar, deletar, atualizar e buscar
 * animes no banco de dados!
 */
@Repository
public interface AnimeRepository extends CrudRepository<Anime,Long> {

    Optional<Anime> findByNome(String nome);
}
