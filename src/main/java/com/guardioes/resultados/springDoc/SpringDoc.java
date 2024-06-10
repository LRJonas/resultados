package com.guardioes.resultados.springDoc;

import com.guardioes.resultados.entity.ResponseDtoPropostas;
import com.guardioes.resultados.web.exception.MensagemErro;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Resultados", description = "Contém todas as operações relativas aos recursos para recuperar dados da votação de proposta")
public interface SpringDoc {

    @Operation(summary = "Buscar todos os resultados",
            description = "Endpoint que recupera todos os dados das propostas.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDtoPropostas.class))),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado",
                    content = @Content(mediaType = "application/json"))
    })
    ResponseEntity<List<ResponseDtoPropostas>> buscarTodos();

    @Operation(summary = "Buscar resultados pro proposta ",
            description = "Endpoint que recupera os dados de uma determinada proposta com base no título.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ResponseDtoPropostas.class))),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado",
                    content = @Content(mediaType = "application/json",
                        schema = @Schema(implementation = MensagemErro.class)))
    })
    ResponseEntity<List<ResponseDtoPropostas>> buscarProposta();
}