package com.example.buoi2.controllers;

import com.example.buoi2.daos.User;
import com.example.buoi2.dtos.UserDTO;
import com.example.buoi2.exceptions.DuplicateException;
import com.example.buoi2.exceptions.NotFoundException;
import com.example.buoi2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
//    @RequestMapping(value = {"/users"},method = RequestMethod.GET)
    @GetMapping
    public ResponseEntity<?> getAllUser(){
        List<User> users = userRepository.findAll();
        if (users.size()==0){
            throw new NotFoundException("No User");
        }
        return ResponseEntity.status(200).body(users);
    }
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO){
        User oldUser = userRepository.findByName(userDTO.getName());
        if (oldUser != null) {
            throw new DuplicateException("Duplicate User");
        }
        User user = new User();
        user.setName(userDTO.getName());
        user.setAddress(userDTO.getAddress());
        user.setAge(userDTO.getAge());
        userRepository.save(user);
        return ResponseEntity.status(201).body(user);
    }

    @PutMapping("/{idUser}")
    public ResponseEntity<?> editUser(@PathVariable Integer idUser,
                                      @RequestBody UserDTO userDTO){
        Optional<User> user = userRepository.findById(idUser);
        if (user.isEmpty()){
            throw new NotFoundException("No user");
        }
        user.get().setName(userDTO.getName());
        user.get().setAge(userDTO.getAge());
        user.get().setAddress(userDTO.getAddress());
        userRepository.save(user.get());
        return ResponseEntity.status(200).body(user.get());
    }
    @PatchMapping("{idUser}")
    public ResponseEntity<?> editName(@PathVariable Integer idUser,
                                      @RequestParam String name){
        Optional<User> user = userRepository.findById(idUser);
        if (user.isEmpty()){
            throw new NotFoundException("No user");
        }
        user.get().setName(name);
        userRepository.save(user.get());
        return ResponseEntity.status(200).body(user.get());
    }
    @DeleteMapping("{idUser}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer idUser){
        Optional<User> user = userRepository.findById(idUser);
        if (user.isEmpty()){
            throw new NotFoundException("No user");
        }
        userRepository.delete(user.get());
        return ResponseEntity.status(200).body("Delete success");

    }
}
