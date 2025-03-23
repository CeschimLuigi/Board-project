package com.luigiceschim.board_project.controllers;

import com.luigiceschim.board_project.dto.board.BoardDTO;
import com.luigiceschim.board_project.dto.board.CreateBoardDTO;
import com.luigiceschim.board_project.services.boardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService service;


    @PostMapping
    public CreateBoardDTO create(@RequestBody BoardDTO dto){
        return service.createBoard(dto.nome());

    }


    @GetMapping("/{id}")
    public BoardDTO getBoard(@PathVariable Long id){
        return service.getBoardWithColumnsWithCards(id);

    }
}
