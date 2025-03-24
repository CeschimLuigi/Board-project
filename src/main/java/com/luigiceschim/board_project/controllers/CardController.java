package com.luigiceschim.board_project.controllers;

import com.luigiceschim.board_project.dto.card.MotivoDTO;
import com.luigiceschim.board_project.services.cardService.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }


    @PutMapping("/{id}/bloquear")
    public ResponseEntity<Void> block(@PathVariable Long id, @RequestBody MotivoDTO dto){
        service.bloquearCard(dto.motivo(), id);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/desbloquear")
    public ResponseEntity<Void> desblock(@PathVariable Long id, @RequestBody String motivo){
        service.desbloquearCard(motivo, id);

        return ResponseEntity.ok().build();
    }
}
