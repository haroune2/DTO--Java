package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.PokemonDTO;
import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.entities.Pokemon;
import com.example.demo.domain.entities.User;
import com.example.demo.service.PokemonMapper;
import com.example.demo.service.PokemonService;
import com.example.demo.service.UserMapper;
import com.example.demo.service.UserService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.slf4j.Logger;

//Un controller contenant des Mapping pour ajouter un pokemon et un dresseur.
@RestController
@RequestMapping("/api")
public class PokemonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokemonController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PokemonService pokemonService;

    /*
     * CREATE
     * => create a new user
     */
    @PostMapping("/dresseur")
    public ResponseEntity<UserDTO> create(@RequestBody User user) {
        LOGGER.info("will create : {} " + user);
        User UserCreate = userService.create(user);
        return ResponseEntity.ok(userMapper.toUserDTO(UserCreate));
    }

    /*
     * CREATE
     * => create a new pokemon
     */
    @PostMapping("/pokemons")
    public ResponseEntity<PokemonDTO> addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.create(pokemon);
        LOGGER.info("will create pokemon: {} " + pokemon);
        return ResponseEntity.ok(pokemonService.create(pokemon));
    }

    /*
     * GET
     * Récupérer les détails d'un dresseur spécifique en fonction de son
     * identifiant.
     */
    // Un mapping pour obtenir un dresseur et la liste de ses pokémon en utilisant
    // le DTO correspondant.
    @GetMapping("/dresseur/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable Long id) {
        LOGGER.info("GET user by id {}", id);
        return ResponseEntity.ofNullable(userService.get(id));

    }

    /*
     * GET
     * Un mapping pour obtenir un pokémon d'après son nom en utilisant le DTO
     * correspondant.
     */
    @GetMapping("/pokemons/{name}")
    public ResponseEntity<PokemonDTO> getPokemon(@PathVariable String name) {
        PokemonDTO pokemonDTO = pokemonService.get(name);
        LOGGER.info("GET pokemons by name {}", name);
        return ResponseEntity.ok(pokemonDTO);

    }
}