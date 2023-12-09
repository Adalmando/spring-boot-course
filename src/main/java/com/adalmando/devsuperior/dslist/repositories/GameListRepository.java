package com.adalmando.devsuperior.dslist.repositories;

import com.adalmando.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
