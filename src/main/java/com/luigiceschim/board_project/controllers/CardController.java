package com.luigiceschim.board_project.controllers;

import com.luigiceschim.board_project.dto.card.MotivoDTO;
import com.luigiceschim.board_project.services.cardService.CardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }


    @PutMapping("/{id}/bloquear")
    public void block(@PathVariable Long id, @RequestBody MotivoDTO dto){
        service.bloquearCard(dto.motivo(), id);
    }

    @PutMapping("/{id}/desbloquear")
    public void desblock(@PathVariable Long id, @RequestBody String motivo){
        service.desbloquearCard(motivo, id);
    }
}
