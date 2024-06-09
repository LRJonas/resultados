package com.guardioes.resultados.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "propostas")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private int aprovar;
    private int rejeitar;
    private int tempo;
    private boolean ativo;
}
