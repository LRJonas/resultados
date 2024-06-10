package com.guardioes.resultados.service;

import com.guardioes.resultados.entity.ResponseDtoPropostas;
import com.guardioes.resultados.exception.ExcecaoPropostaNaoEncontrada;
import com.guardioes.resultados.repository.RepositoryResultado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ServiceResultado {

    private final RepositoryResultado repository;

    @Transactional(readOnly = true)
    public List<ResponseDtoPropostas> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ResponseDtoPropostas> buscar(String propostaTitulo) {
        return repository.findByTitulo(propostaTitulo)
                .orElseThrow(() -> new ExcecaoPropostaNaoEncontrada("Proposta não encontrada"));
    }
}
