package com.luigiceschim.board_project.controllers;

import com.luigiceschim.board_project.dto.card.CardRequestDTO;
import com.luigiceschim.board_project.dto.card.CardResponseDTO;
import com.luigiceschim.board_project.services.colunaService.ColunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/colunas")
public class ColunaController {

    @Autowired
    private ColunaService service;


    @PostMapping("/{id}/createCard")
    public ResponseEntity<CardResponseDTO>  create(@PathVariable Long id, @RequestBody CardRequestDTO dto){
        var result = service.createCard(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping("/{id}/removeCard")
    public ResponseEntity<Void> remove(@PathVariable Long id){
        service.removeCard(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/moveCard")
    public ResponseEntity<Void> moveCard(@PathVariable Long id){
        service.moveCard(id);
        return ResponseEntity.status(HttpStatus.OK).build();

        }


    @PutMapping("/{id}/cancelCard")
    public ResponseEntity<Void> cancelCard(@PathVariable Long id){
        service.cancelCard(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }



    }



