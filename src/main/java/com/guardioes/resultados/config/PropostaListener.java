package com.guardioes.resultados.config;

import com.guardioes.resultados.entity.Resultado;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PropostaListener {

    @KafkaListener(topics = "Resultado", groupId = "resultados")
    public void listen(Resultado resultado) {
        System.out.println("Nova proposta: " + resultado);
    }
}
