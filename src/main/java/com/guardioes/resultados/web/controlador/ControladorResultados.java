package com.guardioes.resultados.web.controlador;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.servico.ServicoResultado;
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
public class ControladorResultados {

    private final ServicoResultado servicoResultado;

    @GetMapping
    public ResponseEntity<List<ResponseDtoPropostas>> buscarTodos(){
        List <ResponseDtoPropostas> resultados = servicoResultado.buscarTodos();
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{propostaTitulo}")
    public ResponseEntity<List<ResponseDtoPropostas>> buscarProposta(@PathVariable String propostaTitulo){
        return ResponseEntity.ok(servicoResultado.buscar(propostaTitulo));
    }
    
}
