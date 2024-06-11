package com.guardioes.resultados.configuracao;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.repositorio.RepositorioResultado;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class ListenerProposta {

    private final RepositorioResultado repository;

    @KafkaListener(topics = "Resultado", groupId = "resultados", containerFactory = "factoryContainerListenerKafka")
    public void consumir(ResponseDtoPropostas resultado) {
        log.info("Proposta {} recebida com sucesso", resultado);

        try {
            repository.save(resultado);
            log.info("Proposta {} salva com sucesso no banco de dados", resultado.getId());
        } catch (Exception e) {
            log.error("Erro ao salvar proposta {} no banco de dados:", resultado.getId(), e);
        }
    }
}
