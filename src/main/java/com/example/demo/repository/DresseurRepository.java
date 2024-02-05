package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.entities.Dresseur;

public interface DresseurRepository extends JpaRepository<Dresseur,Long>{

    
}  
