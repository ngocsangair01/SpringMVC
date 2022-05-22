package com.example.mavenproject3.controllers;

import com.example.mavenproject3.daos.Xe;
import com.example.mavenproject3.dtos.XeDTO;
import com.example.mavenproject3.repositories.LoaiXeRepository;
import com.example.mavenproject3.repositories.NhaXeRepository;
import com.example.mavenproject3.services.IXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class XeController {

    @Autowired
    private IXeService xeService;
    @Autowired
    private NhaXeRepository nhaXeRepository;
    @Autowired
    private LoaiXeRepository loaiXeRepository;
    @RequestMapping(value = {"/createXe"}, method = RequestMethod.GET)
    public String createXe(Model model) {
        model.addAttribute("nhaXes",nhaXeRepository.findAll());
        model.addAttribute("loaiXes",loaiXeRepository.findAll());
        model.addAttribute("xeDTO",new XeDTO());
        return "add-xe";
    }
    @RequestMapping(value = {"/createXe"},method = RequestMethod.POST)
    public String doCreateXe(Model model,
            @Valid @ModelAttribute("xeDTO")XeDTO xeDTO,
                             BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errorBSX",bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "errorBSX";
        }
        xeService.createNewXe(xeDTO.getMaNhaXe(),xeDTO.getMaLoaiXe(),xeDTO);
        System.out.println(xeDTO.toString());
        return "redirect:getAllXe";
    }
    @RequestMapping(value = {"/getAllXe"},method = RequestMethod.GET)
    public String getAllXe(Model model){
        model.addAttribute("xes",xeService.getAllXe());
        return "get-all";
    }
}
