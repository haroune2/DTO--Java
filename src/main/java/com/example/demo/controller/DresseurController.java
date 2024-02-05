package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.entities.Dresseur;
import com.example.demo.repository.DresseurRepository;

@RestController
@RequestMapping("/api")
public class DresseurController {
    //@Autowired
    private DresseurRepository dresseurRepository; 
    
    /* CRUD
     * CREATE => CREATE new dresseur
     * READ => ALL dresseurs 
     * UPDATE => 
     * DELETE => 
     */

     public DresseurController(DresseurRepository dresseurRepository) {
        this.dresseurRepository = dresseurRepository;
    }
    @GetMapping("")
    public  List<Dresseur> get(){
        return dresseurRepository.findAll();  
    }
}
