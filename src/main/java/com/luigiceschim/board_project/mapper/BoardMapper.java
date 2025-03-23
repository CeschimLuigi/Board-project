package com.luigiceschim.board_project.mapper;

import com.luigiceschim.board_project.dto.board.BoardDTO;
import com.luigiceschim.board_project.entities.Board;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface BoardMapper {
    BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);

    @Mapping(source = "colunas", target = "colunas")
    BoardDTO boardToBoardDTO(Board board);

    Board boardDTOToBoard(BoardDTO dto);

}


