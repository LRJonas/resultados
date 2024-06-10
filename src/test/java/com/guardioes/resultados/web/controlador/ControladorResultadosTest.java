package com.guardioes.resultados.web.controlador;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.servico.ServicoResultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ControladorResultadosTest {

    @Mock
    private ServicoResultado servicoResultado;

    @InjectMocks
    private ControladorResultados controladorResultados;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testeBuscarTodos() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(servicoResultado.buscarTodos()).thenReturn(Collections.singletonList(proposta));
        ResponseEntity<List<ResponseDtoPropostas>> responseEntity = controladorResultados.buscarTodos();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals("Teste", responseEntity.getBody().get(0).getTitulo());
    }

    @Test
    public void testeBuscarProposta_QuandoEncontrada() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(servicoResultado.buscar("Teste")).thenReturn(Collections.singletonList(proposta));
        ResponseEntity<List<ResponseDtoPropostas>> responseEntity = controladorResultados.buscarProposta("Teste");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(1, responseEntity.getBody().size());
        assertEquals("Teste", responseEntity.getBody().get(0).getTitulo());
    }

    @Test
    public void testBuscarProposta_QuandoNaoEncontrada() {
        when(servicoResultado.buscar("PropostaInexistente")).thenReturn(Collections.emptyList());
        ResponseEntity<List<ResponseDtoPropostas>> responseEntity = controladorResultados.buscarProposta("PropostaInexistente");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(0, responseEntity.getBody().size());
    }
}
