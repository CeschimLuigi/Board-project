package com.luigiceschim.board_project.exceptions;

public class BoardNaoEncontradoException extends RuntimeException {
    public BoardNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
