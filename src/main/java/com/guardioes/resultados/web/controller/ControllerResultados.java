package com.guardioes.resultados.web.controller;

import com.guardioes.resultados.entity.ResponseDtoPropostas;
import com.guardioes.resultados.service.ServiceResultado;
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
public class ControllerResultados {

    private final ServiceResultado serviceResultado;

    @GetMapping
    public ResponseEntity<List<ResponseDtoPropostas>> buscarTodos(){
        List <ResponseDtoPropostas> resultados = serviceResultado.buscarTodos();
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{propostaTitulo}")
    public ResponseEntity<List<ResponseDtoPropostas>> buscarProposta(@PathVariable String propostaTitulo){
        return ResponseEntity.ok(serviceResultado.buscar(propostaTitulo));
    }
    
}
