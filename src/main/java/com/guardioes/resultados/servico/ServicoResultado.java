package com.guardioes.resultados.servico;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
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

    /*@KafkaListener(groupId = "group-1", topics = "Resultado", containerFactory = "strContainerFactory")
    public void listener(String message) {
        log.info("Receive message {}", message);
    }*/

    @Transactional(readOnly = true)
    public List<ResponseDtoPropostas> buscarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public List<ResponseDtoPropostas> buscar(String propostaTitulo) {
        return repository.findByTitulo(propostaTitulo);
    }
}
