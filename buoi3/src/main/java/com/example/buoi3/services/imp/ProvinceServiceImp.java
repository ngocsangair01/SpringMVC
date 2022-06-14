package com.example.buoi3.services.imp;

import com.example.buoi3.dtos.ProvinceDTO;
import com.example.buoi3.exceptions.DuplicateException;
import com.example.buoi3.exceptions.NotFoundException;
import com.example.buoi3.models.Province;
import com.example.buoi3.repositories.ProvinceRepository;
import com.example.buoi3.services.IProvinceService;
import com.example.buoi3.utils.Convert;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProvinceServiceImp implements IProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private Slugify slugify;
    @Override
    public Province createProvince(ProvinceDTO provinceDTO) {
        Province oldProvince = provinceRepository.findByName(provinceDTO.getName());
        if (oldProvince != null){
            throw new DuplicateException("Dupplicate province");
        }
        Province province = new Province();
        Convert.fromProvinceDTOToProvince(provinceDTO,province);
        slugify = slugify.withTransliterator(true);
        province.setCode(slugify.slugify(provinceDTO.getName()));
        provinceRepository.save(province);
        return province;
    }

    @Override
    public Set<Province> getAllProvince() {
        Set<Province> provinces = new HashSet<>(provinceRepository.findAll());
        if (provinces.size()==0){
            throw new NotFoundException("No province");
        }
        return provinces;
    }

    @Override
    public Province getProvinceByCode(String code) {
        return null;
    }
}
