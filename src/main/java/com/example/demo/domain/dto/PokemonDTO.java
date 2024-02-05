package com.example.demo.domain.dto;
import com.example.demo.domain.PokemonAttribute;

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

public class PokemonDTO {
    private String name;
     private PokemonAttribute attribute;
}
