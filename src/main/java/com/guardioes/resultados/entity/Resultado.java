package com.guardioes.resultados.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "propostas")
@JsonDeserialize
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Titulo da Proposta")
    private String titulo;

    @JsonProperty("Descricao da Proposta")
    private String descricao;

    @JsonProperty("Sugestão de")
    private String nome;

    @JsonProperty("CPF do Funcionario")
    private String funcionarioCpf;

    @JsonProperty("Votos a favor")
    private int aprovar;

    @JsonProperty("Votos contra")
    private int rejeitar;

    @JsonProperty("Tempo para votação (em minutos)")
    private int tempo;

    @JsonProperty("Proposta Ativa para votação")
    private boolean ativo;
}
