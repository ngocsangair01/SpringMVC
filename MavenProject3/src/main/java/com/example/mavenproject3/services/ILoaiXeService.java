package com.example.mavenproject3.services;

import com.example.mavenproject3.daos.LoaiXe;
import com.example.mavenproject3.dtos.LoaiXeDTO;

import java.util.Set;

public interface ILoaiXeService {
    LoaiXe createLoaiXe(LoaiXeDTO loaiXeDTO);
    Set<LoaiXe> getAllLoaiXe();
}
