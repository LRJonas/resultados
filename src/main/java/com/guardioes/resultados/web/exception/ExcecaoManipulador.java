package com.guardioes.resultados.web.exception;

import com.guardioes.resultados.exception.ExcecaoPropostaNaoEncontrada;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExcecaoManipulador {

    @ExceptionHandler(ExcecaoPropostaNaoEncontrada.class)
    public final ResponseEntity<MensagemErro> excecaoPropostaInexistente(ExcecaoPropostaNaoEncontrada ex, HttpServletRequest request) {
        log.error("Erro na API", ex);
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MensagemErro(request, HttpStatus.NOT_FOUND, ex.getMessage()));
    }
}
