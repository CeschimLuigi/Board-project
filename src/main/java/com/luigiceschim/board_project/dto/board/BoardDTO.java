package com.luigiceschim.board_project.dto.board;


import com.luigiceschim.board_project.dto.coluna.ColunaDTO;

import java.util.List;

public record BoardDTO(
        String nome,
        List<ColunaDTO>colunas


) {
}
