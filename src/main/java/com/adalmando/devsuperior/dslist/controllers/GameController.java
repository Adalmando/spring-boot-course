package com.adalmando.devsuperior.dslist.controllers;

import com.adalmando.devsuperior.dslist.dto.GameDTO;
import com.adalmando.devsuperior.dslist.dto.GameMinDTO;
import com.adalmando.devsuperior.dslist.services.GameService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll(){
        List<GameMinDTO> games = gameService.findAll();
        if (games.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(games);
        }
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        return gameService.findById(id);
    }
}
