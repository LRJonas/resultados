package com.guardioes.resultados.repository;

import com.guardioes.resultados.entity.ResponseDtoPropostas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RepositoryResultado extends JpaRepository<ResponseDtoPropostas, Long> {

    Optional<List<ResponseDtoPropostas>> findByTitulo(String propostaTitulo);
}
