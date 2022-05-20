package com.example.mavenproject2.controllers;

import com.example.mavenproject2.daos.User;
import com.example.mavenproject2.dtos.ClassDTO;
import com.example.mavenproject2.dtos.UserDTO;
import com.example.mavenproject2.services.IUserService;
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
public class userController {
    @Autowired
    private IUserService userService;
    @RequestMapping(value = {"/createUser"},method = RequestMethod.GET)
    public String createClass(final Model model,
                              final HttpServletRequest request,
                              final HttpServletResponse response,
                              @ModelAttribute("userDTO")UserDTO userDTO){
        return "add-user";
    }

    @RequestMapping(value = {"/createUser/{idClass}"},method = RequestMethod.POST)
    public String doCreateUser(final ModelMap modelMap,
                                final HttpServletRequest request,
                                final HttpServletResponse response,
                                @PathVariable("idClass") Integer idClass,
                                @ModelAttribute("userDTO") UserDTO userDTO){
        userService.createUser(idClass, userDTO);
        return "add-user";
    }

    @RequestMapping(value = {"/users-by-class/{idClass}"},method = RequestMethod.GET)
    public String findUserByClass(final Model model,
                               final HttpServletRequest request,
                               final HttpServletResponse response,
                                  @PathVariable("idClass") Integer idClass) {
        model.addAttribute("users",userService.getAllUserByClass(idClass));
        return "get-all-user";
    }
}
