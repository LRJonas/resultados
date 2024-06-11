package com.guardioes.resultados.configuracao;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;

@RequiredArgsConstructor
@Configuration
public class ConfiguracaoFactoryConsumidor {

    private final KafkaProperties properties;

    @Bean
    public ConsumerFactory<String, ResponseDtoPropostas> factoryConsumidor() {
        var configs =  new HashMap<String, Object>();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);
        configs.put(ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS, JsonDeserializer.class.getName());
        configs.put(JsonDeserializer.VALUE_DEFAULT_TYPE, ResponseDtoPropostas.class.getName());
        configs.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(), new JsonDeserializer<>(ResponseDtoPropostas.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ResponseDtoPropostas> factoryContainerListenerKafka(
            ConsumerFactory<String, ResponseDtoPropostas> factoryConsumidor
    ) {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, ResponseDtoPropostas>();
        factory.setConsumerFactory(factoryConsumidor);
        return factory;
    }
}
