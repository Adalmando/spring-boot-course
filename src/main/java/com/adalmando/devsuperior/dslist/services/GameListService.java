package com.adalmando.devsuperior.dslist.services;

import com.adalmando.devsuperior.dslist.dto.GameListDTO;
import com.adalmando.devsuperior.dslist.dto.GameMinDTO;
import com.adalmando.devsuperior.dslist.entities.Game;
import com.adalmando.devsuperior.dslist.entities.GameList;
import com.adalmando.devsuperior.dslist.repositories.GameListRepository;
import com.adalmando.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true) // da biblioteca spring, não jakarta!
    public List<GameListDTO> findAll(){
        List<GameList> gamesList = gameListRepository.findAll();
        return gamesList.stream().map(GameListDTO::new).toList();
    }

}
