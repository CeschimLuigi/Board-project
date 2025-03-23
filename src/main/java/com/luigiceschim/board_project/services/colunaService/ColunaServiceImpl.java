package com.luigiceschim.board_project.services.colunaService;

import com.luigiceschim.board_project.dto.card.CardRequestDTO;
import com.luigiceschim.board_project.dto.card.CardResponseDTO;
import com.luigiceschim.board_project.entities.Card;
import com.luigiceschim.board_project.entities.TipoColuna;
import com.luigiceschim.board_project.exceptions.CardEstaCanceladoException;
import com.luigiceschim.board_project.exceptions.CardNaoEncontradoException;
import com.luigiceschim.board_project.exceptions.ColunaLimiteExcedidoException;
import com.luigiceschim.board_project.repositories.BoardRepository;
import com.luigiceschim.board_project.repositories.CardRepository;
import com.luigiceschim.board_project.repositories.ColunaRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ColunaServiceImpl implements ColunaService {

    private static final Logger log = LoggerFactory.getLogger(ColunaServiceImpl.class);
    private final CardRepository cardRepository;
    private final ColunaRepository colunaRepository;

    public ColunaServiceImpl(BoardRepository boardRepository, CardRepository cardRepository, ColunaRepository colunaRepository) {
        this.cardRepository = cardRepository;
        this.colunaRepository = colunaRepository;
    }


    @Override
    @Transactional
    public CardResponseDTO createCard(CardRequestDTO requestDTO, Long id) {
        var colunaInicial = colunaRepository.findFirstColumnByBoardId(id).orElseThrow();

        Card card1 = new Card(requestDTO.titulo(), requestDTO.descricao());
        card1.setColuna(colunaInicial);
        colunaInicial.addCard(card1);

        cardRepository.save(card1);

        return new CardResponseDTO(card1.getId(), requestDTO.titulo(), requestDTO.descricao());

    }

    @Override
    @Transactional
    public void removeCard(Long id) {


        cardRepository.removeCard(id);


    }

    @Override
    @Transactional
    public void moveCard(Long id) {

        final int limiteDeColunas = 4;

        var card = cardRepository.findById(id).orElseThrow(()
        -> new CardNaoEncontradoException("Card não encontrado"));

        int proximaOrdem = card.getColuna().getOrdem() + 1;

        var proximaColuna = colunaRepository.findByOrdem(proximaOrdem).orElseThrow(()
                -> new ColunaLimiteExcedidoException("Movimento invalido, coluna não existe"));




        cardRepository.moveCardToNextColumn(id);


    }

    @Override
    @Transactional
    public void cancelCard(Long id) {

        var card = cardRepository.findById(id).orElseThrow(()
                -> new CardNaoEncontradoException("Card não encontrado"));

        if (card.getColuna().getTipo().equals(TipoColuna.CANCELADO)){
            throw new CardEstaCanceladoException("Este card ja está cancelado");
        }

                cardRepository.cancelCard(id);
    }


}