package com.example.buoi3.repositories;

import com.example.buoi3.models.District;
import com.example.buoi3.models.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<Province,Integer> {
    @Query("select p from Province p where p.name = ?1")
    Province findByName(String name);
    Province findByCode(String code);
}
