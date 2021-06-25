package com.example.controller;

import com.example.model.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping(value = "")
    public String getHomePage(Model model){
        model.addAttribute("user",new User());
        return "index";
    }
@PostMapping(value = "/register")
    public String checkUser(@Valid User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }else {
            model.addAttribute("user",user);
            return "success";
        }
}
}
