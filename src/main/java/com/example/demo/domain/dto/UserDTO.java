package com.example.demo.domain.dto;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString

public class UserDTO {
    private String name;
    private List<PokemonDTO> pokemons;
}
