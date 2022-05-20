package com.example.mavenproject2.repositories;

import com.example.mavenproject2.daos.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClassRepository extends JpaRepository<Class,Integer> {
    Set<Class> findAllByAmountGreaterThanAndAmountLessThan(Integer moreThan, Integer lessThan);
    Class findByMonitor(String monitor);
    Class findByName(String name);
}
