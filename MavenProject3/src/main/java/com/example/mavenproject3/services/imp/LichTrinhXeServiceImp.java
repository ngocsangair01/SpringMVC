package com.example.mavenproject3.services.imp;

import com.example.mavenproject3.daos.LichTrinhXe;
import com.example.mavenproject3.daos.TuyenXe;
import com.example.mavenproject3.daos.Xe;
import com.example.mavenproject3.daos.ids.IdLichTrinhXe;
import com.example.mavenproject3.dtos.LichTrinhXeDTO;
import com.example.mavenproject3.dtos.ids.IdLichTrinhXeDTO;
import com.example.mavenproject3.repositories.LichTrinhXeRepository;
import com.example.mavenproject3.repositories.TuyenXeRepository;
import com.example.mavenproject3.repositories.XeRepository;
import com.example.mavenproject3.services.ILichTrinhXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class LichTrinhXeServiceImp implements ILichTrinhXeService {

    @Autowired
    private XeRepository xeRepository;
    @Autowired
    private LichTrinhXeRepository lichTrinhXeRepository;
    @Autowired
    private TuyenXeRepository tuyenXeRepository;

    @Override
    public Set<LichTrinhXe> getAllLichTrinhXeByIdXe(Integer idXe) {
        Optional<Xe> xe = xeRepository.findById(idXe);
        Set<LichTrinhXe> lichTrinhXes = lichTrinhXeRepository.findAllByXe(xe.get());
        return lichTrinhXes;
    }

    @Override
    public LichTrinhXe createLichTrinhXe(Integer idXe, Integer idTuyen, LichTrinhXeDTO lichTrinhXeDTO, IdLichTrinhXeDTO idLichTrinhXeDTO) {
        Optional<Xe> xe = xeRepository.findById(idXe);
        Optional<TuyenXe> tuyenXe = tuyenXeRepository.findById(idTuyen);
        LichTrinhXe lichTrinhXe = new LichTrinhXe();
        lichTrinhXe.setIdLichTrinhXe(new IdLichTrinhXe(idXe,idLichTrinhXeDTO.getNgayXuatBen(), idLichTrinhXeDTO.getGioXuatBen()));
        lichTrinhXe.setTenTaiXe(lichTrinhXeDTO.getTenTaiXe());
        lichTrinhXe.setSoLuongHanhKhach(lichTrinhXeDTO.getSoLuongHanhKhach());
        lichTrinhXe.setXe(xe.get());
        lichTrinhXe.setTuyenXe(tuyenXe.get());
        return lichTrinhXeRepository.save(lichTrinhXe);
    }
}
