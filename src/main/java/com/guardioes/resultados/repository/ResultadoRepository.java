package com.guardioes.resultados.repository;

import com.guardioes.resultados.entity.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<Resultado, Long> {
}
