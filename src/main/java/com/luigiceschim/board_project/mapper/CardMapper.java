package com.luigiceschim.board_project.mapper;

import com.luigiceschim.board_project.dto.card.CardDTO;
import com.luigiceschim.board_project.entities.Card;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface CardMapper {
    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    CardDTO cardToCardDTO(Card card);

    Card cardDTOToCard(CardDTO dto);
}





