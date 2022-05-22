package com.example.mavenproject3.repositories;

import com.example.mavenproject3.daos.NhaXe;
import com.example.mavenproject3.dtos.NhaXeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface NhaXeRepository extends JpaRepository<NhaXe,Integer> {
    Set<NhaXe> findAllByTenNhaXeContaining(String name);
}
