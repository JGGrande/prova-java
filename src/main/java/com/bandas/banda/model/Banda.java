package com.bandas.banda.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Banda {
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private int numeroParticipantes;
    private String nacionalidade;
    private String genero;
}
