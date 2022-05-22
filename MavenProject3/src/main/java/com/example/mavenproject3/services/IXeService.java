package com.example.mavenproject3.services;

import com.example.mavenproject3.daos.NhaXe;
import com.example.mavenproject3.daos.Xe;
import com.example.mavenproject3.dtos.XeDTO;

import java.util.Set;

public interface IXeService {
    Xe createNewXe(Integer idNhaXe, Integer idLoaiXe,XeDTO xeDTO) throws Exception;
    Set<Xe> getAllXe();
    Set<Xe> getAllByTenNhaXe(Integer idNhaXe);
}
