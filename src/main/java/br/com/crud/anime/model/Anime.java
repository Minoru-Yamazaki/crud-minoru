package br.com.crud.anime.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Anime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;
    private String genero;
    private String anoLancamento;
}
