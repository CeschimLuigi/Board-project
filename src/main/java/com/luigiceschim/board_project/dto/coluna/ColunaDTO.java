package com.luigiceschim.board_project.dto.coluna;

import com.luigiceschim.board_project.dto.card.CardDTO;

import java.util.List;

public record ColunaDTO(
        String nome,
        List<CardDTO>cards
) {
}
