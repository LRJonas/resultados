package com.guardioes.resultados.repositorio;

import com.guardioes.resultados.entidade.PropostaResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioResultado extends JpaRepository<PropostaResponseDto, Long> {
}
