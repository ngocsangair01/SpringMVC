package com.example.mavenproject3.repositories;

import com.example.mavenproject3.daos.NhaXe;
import com.example.mavenproject3.daos.Xe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface XeRepository extends JpaRepository<Xe,Integer> {
    Set<Xe> findAllByNhaXe(NhaXe nhaXe);
}
