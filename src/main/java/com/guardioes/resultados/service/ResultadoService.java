package com.guardioes.resultados.service;

import com.guardioes.resultados.entity.Resultado;
import com.guardioes.resultados.repository.ResultadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class ResultadoService {

    private final ResultadoRepository repository;

    /*@KafkaListener(groupId = "group-1", topics = "Resultado", containerFactory = "strContainerFactory")
    public void listener(String message) {
        log.info("Receive message {}", message);
    }*/

    @Transactional
    public List<Resultado> findAll() {
        return repository.findAll();
    }
}
