package com.example.mavenproject3.services;

import com.example.mavenproject3.daos.LichTrinhXe;
import com.example.mavenproject3.dtos.LichTrinhXeDTO;
import com.example.mavenproject3.dtos.ids.IdLichTrinhXeDTO;

import java.util.Set;

public interface ILichTrinhXeService {
    Set<LichTrinhXe> getAllLichTrinhXeByIdXe(Integer idXe);
    LichTrinhXe createLichTrinhXe(Integer idXe, Integer idTuyen, LichTrinhXeDTO lichTrinhXeDTO, IdLichTrinhXeDTO idLichTrinhXeDTO);

}
