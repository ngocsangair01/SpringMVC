package com.example.mavenproject3.services;

import com.example.mavenproject3.daos.TuyenXe;
import com.example.mavenproject3.dtos.TuyenXeDTO;

public interface ITuyenXeService {
    TuyenXe createTuyenXe(TuyenXeDTO tuyenXeDTO);
}
