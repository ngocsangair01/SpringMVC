package com.example.mavenproject2.services;

import com.example.mavenproject2.daos.User;
import com.example.mavenproject2.dtos.UserDTO;

import java.util.Set;

public interface IUserService {
    Set<User> getAllUserByName(String name);
    Set<User> getAllUser();
    Set<User> getAllUserByClass(Integer idClass);
    User editUser(Integer idUser, UserDTO userDTO);
    User getById(Integer idUser);
    User createUser(Integer idClass, UserDTO userDTO);
}
