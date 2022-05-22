package com.example.mavenproject3.repositories;

import com.example.mavenproject3.daos.LoaiXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiXeRepository extends JpaRepository<LoaiXe,Integer> {
}
