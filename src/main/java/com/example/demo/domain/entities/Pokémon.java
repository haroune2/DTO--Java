package com.example.demo.domain.entities;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import com.example.demo.domain.PokemonAttribute;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 

@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter

public class Pokémon {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name; 
    private PokemonAttribute attribute;

    @Min(0)
    @Max(10)
    private int power; 

    @ManyToOne
    @JoinColumn(name = "dresseur_id")
    private Dresseur dresseur; 
}
