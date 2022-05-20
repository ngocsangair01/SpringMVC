package com.example.mavenproject2.services.serviceimp;

import com.example.mavenproject2.daos.Class;
import com.example.mavenproject2.daos.User;
import com.example.mavenproject2.dtos.UserDTO;
import com.example.mavenproject2.repositories.ClassRepository;
import com.example.mavenproject2.repositories.UserRepository;
import com.example.mavenproject2.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassRepository classRepository;
    @Override
    public Set<User> getAllUserByName(String name) {
        Set<User> users = userRepository.findAllByName(name);
        return users;
    }

    @Override
    public Set<User> getAllUser() {
        Set<User> users = new HashSet<>(userRepository.findAll());
        return users;
    }

    @Override
    public Set<User> getAllUserByClass(Integer idClass) {
        Optional<Class> aClass = classRepository.findById(idClass);
        Set<User> users = userRepository.findAllByAClass(aClass.get());
        return users;
    }

    @Override
    public User editUser(Integer idUser, UserDTO userDTO) {
        Optional<User> user = userRepository.findById(idUser);
        user.get().setName(userDTO.getName());
        user.get().setAddress(userDTO.getAddress());
        user.get().setPhoneNumber(userDTO.getPhoneNumber());
        return userRepository.save(user.get());
    }

    @Override
    public User getById(Integer idUser) {
        Optional<User> user = userRepository.findById(idUser);
        return user.get();
    }

    @Override
    public User createUser(Integer idClass, UserDTO userDTO) {
        Optional<Class> aClass = classRepository.findById(idClass);
        User user = new User(userDTO.getId(),userDTO.getName(), userDTO.getAddress(), userDTO.getPhoneNumber(),aClass.get());
        return userRepository.save(user);
    }
}
