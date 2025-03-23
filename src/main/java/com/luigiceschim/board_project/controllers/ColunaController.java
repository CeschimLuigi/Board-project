package com.luigiceschim.board_project.controllers;

import com.luigiceschim.board_project.dto.card.CardRequestDTO;
import com.luigiceschim.board_project.dto.card.CardResponseDTO;
import com.luigiceschim.board_project.services.colunaService.ColunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/colunas")
public class ColunaController {

    @Autowired
    private ColunaService service;


    @PostMapping("/create/{id}")
    public CardResponseDTO create(@PathVariable Long id, @RequestBody CardRequestDTO dto){
        return service.createCard(dto, id);
    }

    @DeleteMapping("/removeCard/{id}")
    public void remove(@PathVariable Long id){
        service.removeCard(id);
    }

    @PutMapping("/moveCard/{id}")
    public void moveCard(@PathVariable Long id){
        service.moveCard(id);

        }


    @PutMapping("/cancelCard/{id}")
    public void cancelCard(@PathVariable Long id){
        service.cancelCard(id);

    }



    }



