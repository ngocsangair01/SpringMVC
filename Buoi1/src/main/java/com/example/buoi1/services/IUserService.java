package com.example.buoi1.services;

import com.example.buoi1.dtos.UserDTO;
import com.example.buoi1.models.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
    User createUser(UserDTO userDTO);
}
