package com.guardioes.resultados.springDoc;

import com.guardioes.resultados.entity.PropostaResponseDto;
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
                            schema = @Schema(implementation = PropostaResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                    content = @Content)
    })
    ResponseEntity<List<PropostaResponseDto>> buscarTodos();
}