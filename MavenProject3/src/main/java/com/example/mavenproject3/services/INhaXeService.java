package com.example.mavenproject3.services;

import com.example.mavenproject3.daos.NhaXe;
import com.example.mavenproject3.dtos.NhaXeDTO;

import java.util.Set;

public interface INhaXeService {
    NhaXe createNhaXe(NhaXeDTO nhaXeDTO);
    Set<NhaXe> getAllByTenNhaXe(String name);
    void sum();
}
