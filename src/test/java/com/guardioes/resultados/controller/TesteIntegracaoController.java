package com.guardioes.resultados.controller;

import com.guardioes.resultados.entidade.ResponseDtoPropostas;
import com.guardioes.resultados.servico.ServicoResultado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class TesteIntegracaoController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ServicoResultado servicoResultado;

    @Test
    public void testBuscarTodos() throws Exception {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(servicoResultado.buscarTodos()).thenReturn(Collections.singletonList(proposta));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/resultados")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]['Titulo da Proposta']").value("Teste"));
    }

    @Test
    public void testBuscarProposta() throws Exception {
        ResponseDtoPropostas proposta = new ResponseDtoPropostas();
        proposta.setTitulo("Teste");
        when(servicoResultado.buscar("Teste")).thenReturn(Collections.singletonList(proposta));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/resultados/{propostaTitulo}", "Teste")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0]['Titulo da Proposta']").value("Teste"));
    }
}
