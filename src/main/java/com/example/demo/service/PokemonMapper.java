package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.PokemonDTO;
import com.example.demo.domain.entities.Pokemon;

@Service
public class PokemonMapper {

    public PokemonDTO toPokemonDTO(Pokemon pokemon) {
        
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setAttribute(pokemon.getAttribute());
        return pokemonDTO;
    }


}
