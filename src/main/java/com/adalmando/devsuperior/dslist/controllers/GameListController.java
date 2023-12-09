package com.adalmando.devsuperior.dslist.controllers;

import com.adalmando.devsuperior.dslist.dto.GameListDTO;
import com.adalmando.devsuperior.dslist.dto.GameMinDTO;
import com.adalmando.devsuperior.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        List<GameListDTO> gamesList = gameListService.findAll();
        if (gamesList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(gamesList);
        }
    }
}
