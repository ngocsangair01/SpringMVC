package com.example.mavenproject3.controllers;

import com.example.mavenproject3.daos.TuyenXe;
import com.example.mavenproject3.dtos.LichTrinhXeDTO;
import com.example.mavenproject3.dtos.TuyenXeDTO;
import com.example.mavenproject3.dtos.ids.IdLichTrinhXeDTO;
import com.example.mavenproject3.repositories.TuyenXeRepository;
import com.example.mavenproject3.repositories.XeRepository;
import com.example.mavenproject3.services.ILichTrinhXeService;
import com.example.mavenproject3.services.IXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LichTrinhXeController {
    @Autowired
    private ILichTrinhXeService lichTrinhXeService;

    @Autowired
    private IXeService xeService;

    @Autowired
    private XeRepository xeRepository;

    @Autowired
    private TuyenXeRepository tuyenXeRepository;
    @RequestMapping(value = {"/createLichTrinhXe"},method = RequestMethod.GET)
    public String createLichTrinhXe(Model model ){
        model.addAttribute("xes",xeRepository.findAll());
        model.addAttribute("tuyenXes",tuyenXeRepository.findAll());
        model.addAttribute("lichTrinhXeDTO",new LichTrinhXeDTO());
        model.addAttribute("idLichTrinhXeDTO",new IdLichTrinhXeDTO());
        return "add-lich-trinh";
    }
    public String doCreateLichTrinhXe(Model model,
                                      @ModelAttribute("lichTrinhXeDTO")LichTrinhXeDTO lichTrinhXeDTO,
                                      @ModelAttribute("tuyenXeDTO") TuyenXeDTO tuyenXeDTO,
                                      @ModelAttribute("idLichTrinhXeDTO")IdLichTrinhXeDTO idLichTrinhXeDTO) {
        lichTrinhXeService.createLichTrinhXe(idLichTrinhXeDTO.getMaXe(), tuyenXeDTO.getMaTuyen(),lichTrinhXeDTO,idLichTrinhXeDTO);
        return "redirect:getAllXe";
    }
}
