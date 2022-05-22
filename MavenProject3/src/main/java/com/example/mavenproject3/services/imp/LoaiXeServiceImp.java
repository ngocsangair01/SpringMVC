package com.example.mavenproject3.services.imp;

import com.example.mavenproject3.daos.LoaiXe;
import com.example.mavenproject3.dtos.LoaiXeDTO;
import com.example.mavenproject3.repositories.LoaiXeRepository;
import com.example.mavenproject3.services.ILoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoaiXeServiceImp implements ILoaiXeService {
    @Autowired
    private LoaiXeRepository loaiXeRepository;
    @Override
    public LoaiXe createLoaiXe(LoaiXeDTO loaiXeDTO) {
        LoaiXe loaiXe = new LoaiXe();
        loaiXe.setMaLoaiXe(loaiXeDTO.getMaLoaiXe());
        loaiXe.setMoTaLoaiXe(loaiXeDTO.getMoTaLoaiXe());
        loaiXe.setSoLuongChoNgoi(loaiXeDTO.getSoLuongChoNgoi());
        return loaiXeRepository.save(loaiXe);
    }

    @Override
    public Set<LoaiXe> getAllLoaiXe() {
        Set<LoaiXe> loaiXes = new HashSet<>(loaiXeRepository.findAll());
        return loaiXes;
    }
}
