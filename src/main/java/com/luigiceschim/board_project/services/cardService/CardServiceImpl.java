package com.luigiceschim.board_project.services.cardService;

import com.luigiceschim.board_project.exceptions.CardBloqueadoException;
import com.luigiceschim.board_project.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }


    @Override
    public void bloquearCard(String motivo, Long id) {

        var card = cardRepository.findById(id).orElseThrow();

        if (card.isBloqueio()){
            throw new CardBloqueadoException("Card está bloqueado");        }

        card.bloquear(motivo);
        cardRepository.save(card);

    }

    @Override
    public void desbloquearCard(String motivo, Long id) {
        var card = cardRepository.findById(id).orElseThrow();

        if (!card.isBloqueio()){
            throw new IllegalArgumentException("Card está desbloqueado");        }

        card.desbloquear(motivo);

        cardRepository.save(card);


    }
}
