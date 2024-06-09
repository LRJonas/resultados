package com.guardioes.resultados.config;

import com.guardioes.resultados.entity.Resultado;
import com.guardioes.resultados.repository.ResultadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PropostaListener {

    private final ResultadoRepository repository;

//    @KafkaListener(topics = "Resultado", groupId = "resultados")
//    public void listen(Resultado resultado) {
//        System.out.println("Nova proposta: " + resultado);
//    }

    @KafkaListener(topics = "Resultado", groupId = "resultados", containerFactory = "jsonContainerFactory")
    public void listen1(Resultado resultado) {
        log.info("Proposta {}", resultado, " recebida com sucesso");
        repository.save(resultado);
    }
}
