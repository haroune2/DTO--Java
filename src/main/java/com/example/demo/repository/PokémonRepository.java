package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.domain.entities.Pokémon;

public interface PokémonRepository extends JpaRepository<Pokémon, Long>  {
    
}
