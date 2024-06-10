package com.guardioes.resultados.servico;

import com.guardioes.resultados.entidade.PropostaResponseDto;
import com.guardioes.resultados.repositorio.RepositorioResultado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ServicoResultado {

    private final RepositorioResultado repository;

    @Transactional
    public List<PropostaResponseDto> buscarTodos() {
        return repository.findAll();
    }
}
