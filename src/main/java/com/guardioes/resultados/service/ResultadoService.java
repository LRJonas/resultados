package com.guardioes.resultados.service;

import com.guardioes.resultados.repository.ResultadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultadoService {

    private final ResultadoRepository repository;
}
