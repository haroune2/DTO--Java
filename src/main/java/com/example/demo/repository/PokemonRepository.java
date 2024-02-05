package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.entities.Pokemon;
@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>  {
    Optional<Pokemon> findByName(String name);

}
