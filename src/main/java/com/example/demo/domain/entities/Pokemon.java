package com.example.demo.domain.entities;

import java.util.Objects;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import com.example.demo.domain.PokemonAttribute;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString


@Entity
public class Pokemon {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name; 
    private PokemonAttribute attribute;

    @Min(0)
    @Max(10)
    private int power; 
 
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private User user; 
    @Override
    public int hashCode() {
        return Objects.hash(id, name, attribute, power);
    }
    
 
}
