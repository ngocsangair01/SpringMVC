package com.example.mavenproject3.repositories;

import com.example.mavenproject3.daos.LichTrinhXe;
import com.example.mavenproject3.daos.TuyenXe;
import com.example.mavenproject3.daos.Xe;
import com.example.mavenproject3.daos.ids.IdLichTrinhXe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface LichTrinhXeRepository extends JpaRepository<LichTrinhXe, IdLichTrinhXe> {
    Set<LichTrinhXe> findAllByXe(Xe xe);
    LichTrinhXe findByTuyenXe(TuyenXe tuyenXe);
    LichTrinhXe findByXe(Xe xe);
}
