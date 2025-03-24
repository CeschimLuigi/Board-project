package com.luigiceschim.board_project.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CardBloqueadoException.class)
    public ResponseEntity<String> handleCardBloqueado(CardBloqueadoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(CardNaoEncontradoException.class)
    public ResponseEntity<String> handleCardNaoEncontrado(CardNaoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(ColunaLimiteExcedidoException.class)
    public ResponseEntity<String> handleColunaLimite(ColunaLimiteExcedidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(MotivoInvalidoException.class)
    public ResponseEntity<String> handleMotivoInvalido(MotivoInvalidoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(BoardNaoEncontradoException.class)
    public ResponseEntity<String> handleMotivoInvalido(BoardNaoEncontradoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(CardEstaCanceladoException.class)
    public ResponseEntity<String> handleMotivoInvalido(CardEstaCanceladoException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro inesperado.");
    }

}
