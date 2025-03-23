package com.luigiceschim.board_project.services.cardService;

public interface CardService {
    void bloquearCard(String motivo, Long id);
    void desbloquearCard(String motivo, Long id);
}
