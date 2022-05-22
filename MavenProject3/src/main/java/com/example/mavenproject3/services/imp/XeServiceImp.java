package com.example.mavenproject3.services.imp;

import com.example.mavenproject3.daos.LoaiXe;
import com.example.mavenproject3.daos.NhaXe;
import com.example.mavenproject3.daos.Xe;
import com.example.mavenproject3.dtos.XeDTO;
import com.example.mavenproject3.repositories.LoaiXeRepository;
import com.example.mavenproject3.repositories.NhaXeRepository;
import com.example.mavenproject3.repositories.XeRepository;
import com.example.mavenproject3.services.INhaXeService;
import com.example.mavenproject3.services.IXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class XeServiceImp implements IXeService {
    @Autowired
    private XeRepository xeRepository;

    @Autowired
    private NhaXeRepository nhaXeRepository;

    @Autowired
    private LoaiXeRepository loaiXeRepository;

    @Override
    public Xe createNewXe(Integer idNhaXe, Integer idLoaiXe,XeDTO xeDTO) throws Exception {
        Xe xe = new Xe();
        xe.setMaXe(xeDTO.getMaXe());
        xe.setHangSanXuat(xeDTO.getHangSanXuat());
        xe.setBienSo(xeDTO.getBienSo());
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusMonths(1);
        LocalDate localDate1 = LocalDate.parse(xeDTO.getHanKiemDinh());
        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println(localDate.isBefore(localDate1));
        if(localDate.isAfter(localDate1)){
            throw new Exception("Han kiem dinh khong dung");
        }
        xe.setHanKiemDinh(xeDTO.getHanKiemDinh());
        Optional<NhaXe> nhaXe = nhaXeRepository.findById(idNhaXe);
        xe.setNhaXe(nhaXe.get());
        Optional<LoaiXe> loaiXe = loaiXeRepository.findById(idLoaiXe);
        xe.setLoaiXe(loaiXe.get());
        return xeRepository.save(xe);
    }

    @Override
    public Set<Xe> getAllXe() {
        Set<Xe> xes = new HashSet<>(xeRepository.findAll());
        return xes;
    }

    @Override
    public Set<Xe> getAllByTenNhaXe(Integer idNhaXe) {
        Optional<NhaXe> nhaXe = nhaXeRepository.findById(idNhaXe);
        Set<Xe> xes = xeRepository.findAllByNhaXe(nhaXe.get());
        return xes;
    }
}
