package com.example.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.domain.dto.UserDTO;
import com.example.demo.domain.entities.User;
import com.example.demo.domain.execption.UserExeption;
import com.example.demo.repository.UserRepository;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    

    public List<User> list() {
        return userRepository.findAll();
    }

    public User create(User user) {
        if (Objects.isNull(user)) {
            throw new UserExeption(HttpStatus.CONFLICT, "user cant be null");
        } else {
            return userRepository.save(user);
        }
    }

    public UserDTO get(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userMapper.toUserDTO(userOptional.get()); 
        } else {
            throw new UserExeption(HttpStatus.NOT_FOUND, "user " + id + " is not found");
        }

    }

}
