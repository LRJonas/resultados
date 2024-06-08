package com.guardioes.resultados;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ResultadosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultadosApplication.class, args);
	}

}
