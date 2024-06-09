package com.guardioes.resultados.repository;

import com.guardioes.resultados.entity.PropostaResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultadoRepository extends JpaRepository<PropostaResponseDto, Long> {
}
