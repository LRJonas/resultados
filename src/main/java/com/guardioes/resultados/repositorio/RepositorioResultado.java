package com.guardioes.resultados.repositorio;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositorioResultado extends JpaRepository<ResponseDtoPropostas, Long> {

    Optional<List<ResponseDtoPropostas>> findByTitulo(String propostaTitulo);
}
