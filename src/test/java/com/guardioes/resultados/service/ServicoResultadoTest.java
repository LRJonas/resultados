package com.guardioes.resultados.service;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.excecao.ExcecaoPropostaNaoEncontrada;
import com.guardioes.resultados.repositorio.RepositorioResultado;
import com.guardioes.resultados.servico.ServicoResultado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
public class ServicoResultadoTest {

    @Mock
    private RepositorioResultado repository;

    @InjectMocks
    private ServicoResultado service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testeBuscarTodos() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(repository.findAll()).thenReturn(Collections.singletonList(proposta));
        List<ResponseDtoPropostas> propostas = service.buscarTodos();
        assertEquals(1, propostas.size());
        assertEquals("Teste", propostas.get(0).getTitulo());
    }

    @Test
    public void testBuscarPorTitulo_QuandoEncontrado() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(repository.findByTitulo("Teste")).thenReturn(Optional.of(Collections.singletonList(proposta)));
        List<ResponseDtoPropostas> propostas = service.buscar("Teste");
        assertEquals(1, propostas.size());
        assertEquals("Teste", propostas.get(0).getTitulo());
    }

    @Test
    public void testBuscarPorTitulo_QuandoNaoEncontrado() {
        when(repository.findByTitulo("PropostaInexistente")).thenReturn(Optional.empty());
        assertThrows(ExcecaoPropostaNaoEncontrada.class, () -> service.buscar("PropostaInexistente"));
    }
}
