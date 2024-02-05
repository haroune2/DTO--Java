package com.example.demo.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.entities.User;
import com.example.demo.service.UserMapper;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.slf4j.Logger;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService; 
    @Autowired
    private UserMapper userMapper; 
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class); 
 

    
    /* CRUD
     * CREATE => CREATE new user
     * READ => ALL users 
     * UPDATE => 
     * DELETE => 
     */

    /* 
     * get() => retun a lis of users 
     */
    @GetMapping("")
    public  ResponseEntity<List<User>> list(){
        List<User> users = userService.list(); 
        LOGGER.info("GET user : "+ users);
        return ResponseEntity.ofNullable(users); 
       
    }
    /* CREATE 
     *  => create a new user 
     */
    @PostMapping("")
    public ResponseEntity<UserDTO> create(@RequestBody User user){
        LOGGER.info("will create : {} " +user);
        User UserCreate = userService.create(user); 
        return ResponseEntity.ok( userMapper.toUserDTO(UserCreate)); 
    }

    @GetMapping("")
    public  ResponseEntity<List<User>> get(){
        List<User> users = userService.get(); 
        LOGGER.info("GET user : "+ users);
        return ResponseEntity.ofNullable(users); 
       
    }

}
