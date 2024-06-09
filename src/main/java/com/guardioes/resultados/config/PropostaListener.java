package com.guardioes.resultados.config;

import com.guardioes.resultados.entity.Resultado;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PropostaListener {

//    @KafkaListener(topics = "Resultado", groupId = "resultados")
//    public void listen(Resultado resultado) {
//        System.out.println("Nova proposta: " + resultado);
//    }

    @KafkaListener(topics = "Resultado", groupId = "resultados", containerFactory = "jsonContainerFactory")
    public void listen() {
        log.info("Validando proposta");
    }
}
