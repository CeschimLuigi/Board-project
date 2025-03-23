package com.luigiceschim.board_project.services.colunaService;

import com.luigiceschim.board_project.dto.card.CardRequestDTO;
import com.luigiceschim.board_project.dto.card.CardResponseDTO;

public interface ColunaService {
    CardResponseDTO createCard(CardRequestDTO requestDTO, Long id);
    void removeCard(Long id);
    void moveCard(Long id);
    void cancelCard(Long id);


}
