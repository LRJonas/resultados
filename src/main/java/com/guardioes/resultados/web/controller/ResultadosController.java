package com.guardioes.resultados.web.controller;

import com.guardioes.resultados.entity.PropostaResponseDto;
import com.guardioes.resultados.service.ResultadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/resultados")
public class ResultadosController {

    private final ResultadoService resultadoService;

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> buscarTodos(){
        List <PropostaResponseDto> resultados = resultadoService.findAll();
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{propostaTitulo}")
    public ResponseEntity<List<PropostaResponseDto>> buscarProposta(@PathVariable String propostaTitulo){
        return ResponseEntity.ok(resultadoService.buscar(propostaTitulo));
    }
    
}
