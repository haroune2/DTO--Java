package com.example.demo.domain.entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString

@Entity
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "age")
    private int age;

    @Min(0)
    @Max(100)
    private int level;

    @OneToMany(mappedBy = "user",  cascade = CascadeType.ALL)
    Set<Pokemon> pokemons = new HashSet<>();
 


    
}
