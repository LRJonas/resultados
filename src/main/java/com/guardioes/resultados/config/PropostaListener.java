package com.guardioes.resultados.config;

import com.guardioes.resultados.entity.PropostaResponseDto;
import com.guardioes.resultados.repository.ResultadoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PropostaListener {

    private final ResultadoRepository repository;

    @KafkaListener(topics = "Resultado", groupId = "resultados", containerFactory = "kafkaListenerContainerFactory")
    public void listen(PropostaResponseDto resultado) {
        log.info("Proposta {} recebida com sucesso", resultado);

        try {
            repository.save(resultado);
            log.info("Proposta {} salva com sucesso no banco de dados", resultado.getId());
        } catch (Exception e) {
            log.error("Erro ao salvar proposta {} no banco de dados:", resultado.getId(), e);
        }
    }
}
