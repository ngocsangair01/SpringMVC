package com.example.buoi1.controllers;

import com.example.buoi1.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/users"},method = RequestMethod.GET)
    public String findAllUser(final Model model){
        model.addAttribute("users",userService.findAll());
        return "home";
    }
}
