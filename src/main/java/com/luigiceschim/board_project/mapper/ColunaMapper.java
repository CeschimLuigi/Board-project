package com.luigiceschim.board_project.mapper;

import com.luigiceschim.board_project.dto.coluna.ColunaDTO;
import com.luigiceschim.board_project.entities.Coluna;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper
public interface ColunaMapper {
    ColunaMapper INSTANCE = Mappers.getMapper(ColunaMapper.class);

    @Mapping(source = "cards", target = "cards")
    ColunaDTO colunaToColunaDTO(Coluna coluna);

    Coluna colunaDTOToColuna(ColunaDTO dto);
}




