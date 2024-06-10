package com.guardioes.resultados.repository;

import com.guardioes.resultados.entity.PropostaResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<PropostaResponseDto, Long> {

    List<PropostaResponseDto> findByTitulo(String propostaTitulo);
}
