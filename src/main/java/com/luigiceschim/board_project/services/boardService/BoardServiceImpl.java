package com.luigiceschim.board_project.services.boardService;

import com.luigiceschim.board_project.dto.board.BoardDTO;
import com.luigiceschim.board_project.dto.board.CreateBoardDTO;
import com.luigiceschim.board_project.entities.Board;
import com.luigiceschim.board_project.mapper.BoardMapper;
import com.luigiceschim.board_project.repositories.BoardRepository;
import org.springframework.stereotype.Service;


@Service
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    public BoardServiceImpl(BoardRepository repository) {
        this.repository = repository;
    }


    @Override
    public CreateBoardDTO createBoard(String nome) {
       var result = repository.save(new Board(nome));
        return  new CreateBoardDTO(result.getId(), result.getNome());
    }

    @Override
    public BoardDTO getBoardWithColumnsWithCards(Long id) {
        var result = repository.findById(id).orElseThrow(() -> new RuntimeException("NOT FOUND"));
        return BoardMapper.INSTANCE.boardToBoardDTO(result);
    }


}
