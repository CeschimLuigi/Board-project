package com.luigiceschim.board_project.dto.board;

import com.luigiceschim.board_project.entities.Coluna;

import java.util.List;

public record BoardGetDTO(
        String name,
        List<Coluna>colunas
) {
}
