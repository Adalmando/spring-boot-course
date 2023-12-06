package com.adalmando.devsuperior.dslist.repositories;

import com.adalmando.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
