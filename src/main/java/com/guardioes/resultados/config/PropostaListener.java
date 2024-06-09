package com.guardioes.resultados.config;

import com.guardioes.resultados.entity.Resultado;
import com.guardioes.resultados.repository.ResultadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PropostaListener {

    private final ResultadoRepository repository;

    @KafkaListener(topics = "Resultado", groupId = "resultados")
    public void listen(Resultado resultado) {
        try {
            System.out.println("Nova proposta: " + resultado);
            repository.save(resultado);
        } catch (Exception e) {
            System.out.println("Erro ao salvar proposta: " + e.getMessage());
        }
    }
}
