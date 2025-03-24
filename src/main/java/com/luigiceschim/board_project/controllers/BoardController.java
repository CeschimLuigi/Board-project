package com.luigiceschim.board_project.controllers;

import com.luigiceschim.board_project.dto.board.BoardDTO;
import com.luigiceschim.board_project.dto.board.CreateBoardDTO;
import com.luigiceschim.board_project.services.boardService.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private BoardService service;


    @PostMapping("/create")
    public ResponseEntity<CreateBoardDTO> create(@RequestBody BoardDTO dto){

        var result = service.createBoard(dto.nome());

        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }


    @GetMapping("/{id}/obterBoard")
    public ResponseEntity<BoardDTO> getBoard(@PathVariable Long id){
        var result = service.getBoardWithColumnsWithCards(id);

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
}
