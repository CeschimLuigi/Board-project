package com.luigiceschim.board_project.services.boardService;

import com.luigiceschim.board_project.dto.board.BoardDTO;
import com.luigiceschim.board_project.dto.board.CreateBoardDTO;



public interface BoardService {
    CreateBoardDTO createBoard(String nome);
    BoardDTO getBoardWithColumnsWithCards(Long id);

}
