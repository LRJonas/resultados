package com.guardioes.resultados.service;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.repositorio.RepositorioResultado;
import com.guardioes.resultados.servico.ServicoResultado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TesteIntegracaoServico {

    @Autowired
    private ServicoResultado service;

    @MockBean
    private RepositorioResultado repository;

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
    public void testBuscarPorTitulo() {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(repository.findByTitulo("Teste")).thenReturn(Optional.of(Collections.singletonList(proposta)));
        List<ResponseDtoPropostas> propostas = service.buscar("Teste");
        assertEquals(1, propostas.size());
        assertEquals("Teste", propostas.get(0).getTitulo());
    }
}
