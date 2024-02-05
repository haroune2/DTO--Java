package com.example.demo.domain.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Dresseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private int age;

    @Min(0)
    @Max(100)
    private int level;

    @OneToMany(mappedBy = "dresseur", cascade = CascadeType.ALL)
    Set<Pokémon> pokémons = new HashSet<>();
}
