package com.example.mavenproject2.repositories;

import com.example.mavenproject2.daos.Class;
import com.example.mavenproject2.daos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Set<User> findAllByName(String name);
    Set<User> findAllByAClass(Class aClass);
}
