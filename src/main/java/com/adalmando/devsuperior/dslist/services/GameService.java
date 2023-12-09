package com.adalmando.devsuperior.dslist.services;

import com.adalmando.devsuperior.dslist.dto.GameDTO;
import com.adalmando.devsuperior.dslist.dto.GameMinDTO;
import com.adalmando.devsuperior.dslist.entities.Game;
import com.adalmando.devsuperior.dslist.exceptions.EntityNotFoundException;
import com.adalmando.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true) // da biblioteca spring, não jakarta!
    public List<GameMinDTO> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(GameMinDTO::new).toList();
        // return games.stream().map(game -> new GameMinDTO(game)).toList(); essa é a forma mais verbosa
    }

    @Transactional(readOnly = true) // da biblioteca spring, não jakarta!
    public GameDTO findById(Long id){
        Game game = gameRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Game não encontrado!"));
        return new GameDTO(game);
    }
}
