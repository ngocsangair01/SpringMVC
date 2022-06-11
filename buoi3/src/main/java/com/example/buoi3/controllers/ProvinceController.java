package com.example.buoi3.controllers;

import com.example.buoi3.dtos.ProvinceDTO;
import com.example.buoi3.exceptions.DuplicateException;
import com.example.buoi3.exceptions.NotFoundException;
import com.example.buoi3.models.Province;
import com.example.buoi3.repositories.ProvinceRepository;
import com.example.buoi3.utils.Convert;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/provinces")
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private Slugify slugify;
    @GetMapping
    public ResponseEntity<?> getAllProvinces(){
        List<Province> provinces = provinceRepository.findAll();
        if (provinces.size()==0){
            throw new NotFoundException("No provinces");
        }
        return ResponseEntity.status(200).body(provinces);
    }
    @PostMapping
    public ResponseEntity<?> createProvince(@RequestBody ProvinceDTO provinceDTO){
        Province province = provinceRepository.findByName(provinceDTO.getName());
        if (province != null) {
            throw new DuplicateException("Duplicate province");
        }
        System.out.println(1);
        Province newProvince = new Province();
        Convert.fromProvinceDTOToProvince(provinceDTO,newProvince);
        slugify = slugify.withTransliterator(true);
        newProvince.setCode(slugify.slugify(provinceDTO.getName()));
        provinceRepository.save(newProvince);
        return ResponseEntity.status(201).body(newProvince);
    }

    @GetMapping("/{code}")
    public ResponseEntity<?> getProvinceByCode(@PathVariable("code")String code){
        Province province = provinceRepository.findByCode(code);
        if (province == null) {
            throw new NotFoundException("No province");
        }
        return ResponseEntity.status(200).body(province);
    }
}
