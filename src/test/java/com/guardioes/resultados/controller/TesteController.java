package com.guardioes.resultados.controller;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.servico.ServicoResultado;
import com.guardioes.resultados.web.controlador.ControladorResultados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TesteController {

    @Mock
    private ServicoResultado service;

    @InjectMocks
    private ControladorResultados controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testeBuscarTodos() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(service.buscarTodos()).thenReturn(Collections.singletonList(proposta));

        ResponseEntity<List<ResponseDtoPropostas>> response = controller.buscarTodos();
        assertEquals(1, response.getBody().size());
        assertEquals("Teste", response.getBody().get(0).getTitulo());
    }

    @Test
    public void testeBuscarPropostaPorTitulo() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(service.buscar("Teste")).thenReturn(Collections.singletonList(proposta));

        ResponseEntity<List<ResponseDtoPropostas>> response = controller.buscarProposta("Teste");
        assertEquals(1, response.getBody().size());
        assertEquals("Teste", response.getBody().get(0).getTitulo());
    }
}