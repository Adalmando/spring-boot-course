package com.adalmando.devsuperior.dslist.controllers;

import com.adalmando.devsuperior.dslist.dto.GameListDTO;
import com.adalmando.devsuperior.dslist.dto.GameMinDTO;
import com.adalmando.devsuperior.dslist.services.GameListService;
import com.adalmando.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll(){
        List<GameListDTO> gamesList = gameListService.findAll();
        if (gamesList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(gamesList);
        }
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findGameByList(@PathVariable Long listId){
        List<GameMinDTO> gamesList = gameService.findByList(listId);
        if (gamesList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(gamesList);
        }
    }
}
