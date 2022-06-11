package com.example.buoi3.utils;

import com.example.buoi3.dtos.DistrictDTO;
import com.example.buoi3.dtos.ProvinceDTO;
import com.example.buoi3.models.District;
import com.example.buoi3.models.Province;

public class Convert {
    public static Province fromProvinceDTOToProvince(ProvinceDTO provinceDTO,
                                                     Province province){
        if (provinceDTO.getName() != null){
            province.setName(provinceDTO.getName());
        }
        return province;
    }
    public static District fromDistrictDTOToDistrict(DistrictDTO districtDTO,
                                                     District district){
        if (districtDTO.getName() != null){
            district.setName(districtDTO.getName());
        }
        return district;
    }
}
