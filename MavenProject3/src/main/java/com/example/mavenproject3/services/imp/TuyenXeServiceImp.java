package com.example.mavenproject3.services.imp;

import com.example.mavenproject3.daos.TuyenXe;
import com.example.mavenproject3.dtos.TuyenXeDTO;
import com.example.mavenproject3.repositories.TuyenXeRepository;
import com.example.mavenproject3.services.ITuyenXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuyenXeServiceImp implements ITuyenXeService {
    @Autowired
    private TuyenXeRepository tuyenXeRepository;
    @Override
    public TuyenXe createTuyenXe(TuyenXeDTO tuyenXeDTO) {
        TuyenXe tuyenXe = new TuyenXe();
        tuyenXe.setMaTuyen(tuyenXeDTO.getMaTuyen());
        tuyenXe.setTenTuyen(tuyenXeDTO.getTenTuyen());
        tuyenXe.setDonGia(tuyenXeDTO.getDonGia());
        return tuyenXeRepository.save(tuyenXe);
    }
}
