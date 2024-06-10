package com.guardioes.resultados.repositorio;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositorioResultado extends JpaRepository<ResponseDtoPropostas, Long> {

    List<ResponseDtoPropostas> findByTitulo(String propostaTitulo);
}
