package com.example.buoi3.controllers;

import com.example.buoi3.dtos.DistrictDTO;
import com.example.buoi3.exceptions.NotFoundException;
import com.example.buoi3.models.District;
import com.example.buoi3.models.Province;
import com.example.buoi3.repositories.DistrictRepository;
import com.example.buoi3.repositories.ProvinceRepository;
import com.example.buoi3.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/districts")
public class DistrictController {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping
    public ResponseEntity<?> getAllDistrict(){
        return ResponseEntity.status(200).body(districtRepository.findAll());
    }

    @PostMapping("/{code}")
    public ResponseEntity<?> createDistrict(@PathVariable("code")String code,
                                            @RequestBody DistrictDTO districtDTO){
        Province province = provinceRepository.findByCode(code);
        if (province == null) {
            throw new NotFoundException("No province");
        }
        District district = new District();
        Convert.fromDistrictDTOToDistrict(districtDTO,district);
        district.setProvince(province);
        districtRepository.save(district);
        return ResponseEntity.status(201).body(district);
    }
}
