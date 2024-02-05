package com.example.demo.service;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.PokemonDTO;
import com.example.demo.domain.entities.Pokemon;
import com.example.demo.domain.execption.PokemonException;
import com.example.demo.repository.PokemonRepository;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private PokemonMapper pokemonMapper;

    public PokemonDTO create(Pokemon pokemon) {
        if (Objects.isNull(pokemon)) {
            throw new PokemonException(HttpStatus.CONFLICT, "pokemon cant be null");
        }
        if (pokemonRepository.existsById(pokemon.getId())) {
            throw new PokemonException(HttpStatus.CONFLICT, "pokemon " + pokemon + " exists.");
        }
        return pokemonMapper.toPokemonDTO(pokemon);
    }

    public PokemonDTO get(String name) {
        Optional<Pokemon> pokemon = pokemonRepository.findByName(name);
        if (pokemon.isPresent()) {
            return pokemonMapper.toPokemonDTO(pokemon.get());
        } else {
            throw new PokemonException(HttpStatus.NOT_FOUND, "Pokemon: " + name + " is not found");

        }
    }
}