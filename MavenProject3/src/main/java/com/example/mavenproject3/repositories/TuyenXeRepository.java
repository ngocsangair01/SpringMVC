package com.example.mavenproject3.repositories;

import com.example.mavenproject3.daos.TuyenXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuyenXeRepository extends JpaRepository<TuyenXe,Integer> {
}
