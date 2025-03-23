package com.luigiceschim.board_project.exceptions;

public class CardNaoEncontradoException extends RuntimeException {
    public CardNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
