package com.example.buoi3.controllers;

import com.example.buoi3.bases.BaseController;
import com.example.buoi3.dtos.ProvinceDTO;
import com.example.buoi3.exceptions.DuplicateException;
import com.example.buoi3.exceptions.NotFoundException;
import com.example.buoi3.models.Province;
import com.example.buoi3.repositories.ProvinceRepository;
import com.example.buoi3.services.IProvinceService;
import com.example.buoi3.utils.Convert;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/provinces")
public class ProvinceController extends BaseController<Province> {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping
    public ResponseEntity<?> getAllProvinces(){
        return this.resSetSuccess(provinceService.getAllProvince());
    }
    @PostMapping
    public ResponseEntity<?> createProvince(@RequestBody ProvinceDTO provinceDTO){
        return this.resSuccess(provinceService.createProvince(provinceDTO));
    }

//    @GetMapping("/{code}")
//    public ResponseEntity<?> getProvinceByCode(@PathVariable("code")String code){
//
//    }
}
