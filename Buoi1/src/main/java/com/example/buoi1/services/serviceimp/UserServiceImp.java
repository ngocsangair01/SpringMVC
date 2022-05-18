package com.example.buoi1.services.serviceimp;

import com.example.buoi1.dtos.UserDTO;
import com.example.buoi1.models.User;
import com.example.buoi1.repositories.UserRepository;
import com.example.buoi1.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// Autowired tu repository -> service
public class UserServiceImp implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public User createUser(UserDTO userDTO) {
        User user = new User(userDTO.getName(),userDTO.getAddress());
        return userRepository.save(user);
    }
}
