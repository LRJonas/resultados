package com.guardioes.resultados.web.controller;

import com.guardioes.resultados.entity.Resultado;
import com.guardioes.resultados.service.ResultadoService;
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

    private final ResultadoService resultadoService;

    @GetMapping("/buscar-todos")
    public ResponseEntity<List<Resultado>> buscarTodos(){
        List <Resultado> resultados = resultadoService.findAll();
        return ResponseEntity.ok(resultados);
    }
}
