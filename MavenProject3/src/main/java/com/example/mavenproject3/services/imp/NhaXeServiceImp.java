package com.example.mavenproject3.services.imp;

import com.example.mavenproject3.daos.NhaXe;
import com.example.mavenproject3.dtos.NhaXeDTO;
import com.example.mavenproject3.repositories.NhaXeRepository;
import com.example.mavenproject3.services.INhaXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class NhaXeServiceImp implements INhaXeService {
    @Autowired
    private NhaXeRepository nhaXeRepository;
    @Override
    public NhaXe createNhaXe(NhaXeDTO nhaXeDTO) {
        NhaXe nhaXe = new NhaXe();
        nhaXe.setMaNhaXe(nhaXeDTO.getMaNhaXe());
        nhaXe.setTenNhaXe(nhaXeDTO.getTenNhaXe());
        nhaXe.setNamThanhLap(nhaXeDTO.getNamThanhlap());
        return nhaXeRepository.save(nhaXe);
    }

    @Override
    public Set<NhaXe> getAllByTenNhaXe(String name) {
        Set<NhaXe> nhaXes = nhaXeRepository.findAllByTenNhaXeContaining(name);
        return nhaXes;
    }

    @Override
    public void sum() {

    }
}
