package com.example.buoi1.repositories;

import com.example.buoi1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// Cung caaps cac phuong thuc
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAllByName(String name);
}
