package com.guardioes.resultados.web.controller;

import com.guardioes.resultados.entidade.PropostaResponseDto;
import com.guardioes.resultados.servico.ServicoResultado;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/resultados")
public class ResultadosController {

    private final ServicoResultado servicoResultado;

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<PropostaResponseDto>> buscarTodos(){
        List <PropostaResponseDto> resultados = servicoResultado.buscarTodos();
        return ResponseEntity.ok(resultados);
    }

}
