package com.example.mavenproject2.controllers;

import com.example.mavenproject2.daos.Class;
import com.example.mavenproject2.dtos.ClassDTO;
import com.example.mavenproject2.services.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ClassController {
    @Autowired
    private IClassService classService;
    @RequestMapping(value = {"/classes"},method = RequestMethod.GET)
    public String findAllClass(final Model model,
                                    final HttpServletRequest request,
                                    final HttpServletResponse response) {
        model.addAttribute("classes",classService.getAllClass());
        return "get-all-class";
    }
    //===========================create new Class=====================
    @RequestMapping(value = {"/"},method = RequestMethod.GET)
    public String createClass(final Model model,
                             final HttpServletRequest request,
                             final HttpServletResponse response){
        model.addAttribute("classDTO", new ClassDTO());
        return "add-class";
    }
    @RequestMapping(value = {"/createClass"},method = RequestMethod.POST)
    public String doCreateClass(final ModelMap modelMap,
                               final HttpServletRequest request,
                               final HttpServletResponse response,
                               @ModelAttribute("classDTO") ClassDTO classDTO){
        classService.createClass(classDTO);
        modelMap.addAttribute("classDTO",classDTO);
        return "add-class";
    }
//===================Edit Class==============================================

    @RequestMapping(value = {"/classes/edit/{idClass}"},method = RequestMethod.GET)
    public String editUser(final Model model,
                           final HttpServletRequest request,
                           final HttpServletResponse response,
                           @PathVariable("idClass")Integer idClass){
        Class aClass = classService.getById(idClass);
        model.addAttribute("classDTO", aClass);
        return "edit-class";
    }

    @RequestMapping(value = {"/classes/edit/{idClass}"},method = RequestMethod.POST)
    public String doEditUser(final ModelMap modelMap,
                             final HttpServletRequest request,
                             final HttpServletResponse response,
                             @PathVariable("idClass")Integer idClass,
                             @ModelAttribute("classDTO")ClassDTO classDTO){
        modelMap.addAttribute("classDTO",classDTO);
        classService.editClass(idClass,classDTO);
        return "edit-class";
    }
//========================Get All Class By Amount=========================
//@RequestMapping(value = {"/classes/filter/amount/{more}/{less}"},method = RequestMethod.GET )
//public String filterByAmount(final Model model,
//                            final HttpServletRequest request,
//                            final HttpServletResponse response,
//                             @PathVariable("more") Integer more,
//                             @PathVariable("less") Integer less) {
//        model.addAttribute("classes",classService.getAllClassByAmount(more,less));
//    return "get-all-class";
//    }

    @RequestMapping(value = {"/classes/filter/amount"},method = RequestMethod.GET )
    public String doFilterByAmount(final Model model,
                                 final HttpServletRequest request,
                                 final HttpServletResponse response ){
        Integer more = Integer.parseInt(request.getParameter("getMoreThan"));
        Integer less = Integer.parseInt(request.getParameter("getLessThan"));
        model.addAttribute("classes",classService.getAllClassByAmount(more,less));
        return "get-all-class";
    }
}

