package com.example.demo.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.entities.User;

@Service
public class UserMapper {

    private final PokemonMapper pokemonMapper;

    public UserMapper(PokemonMapper pokemonMapper) {
        this.pokemonMapper = pokemonMapper;
    }

    public UserDTO toUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());

        userDTO.setPokemons(
                user.getPokemons()
                        .stream()
                        .map(pokemonMapper::toPokemonDTO) // fonction de transformation à chaque élément du flux
                        //.map(pokemon -> pokemonMapper.toPokemonDTO(pokemon))
                        .collect(Collectors.toList()));

        return userDTO;
    }
}
