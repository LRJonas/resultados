package com.guardioes.resultados.config;

import com.guardioes.resultados.entity.Resultado;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaListener {
    private static final Logger log = LogManager.getLogger(PropostaListener.class);

//    @KafkaListener(topics = "Resultado", groupId = "resultados")
//    public void listen(Resultado resultado) {
//        System.out.println("Nova proposta: " + resultado);
//    }

    @KafkaListener(topics = "Resultado", groupId = "resultados", containerFactory = "jsonContainerFactory")
    public void listen1(Resultado resultado) {
        log.info("Proposta {}", resultado, " recebida com sucesso");
    }
}
