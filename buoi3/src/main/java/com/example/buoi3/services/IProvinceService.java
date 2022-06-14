package com.example.buoi3.services;

import com.example.buoi3.dtos.ProvinceDTO;
import com.example.buoi3.models.Province;

import java.util.Set;

public interface IProvinceService {
    Province createProvince(ProvinceDTO provinceDTO);
    Set<Province> getAllProvince();
    Province getProvinceByCode(String code);
}
