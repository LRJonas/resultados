package com.guardioes.resultados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class AplicacaoResultados {

	public static void main(String[] args) {
		SpringApplication.run(AplicacaoResultados.class, args);
	}

}
