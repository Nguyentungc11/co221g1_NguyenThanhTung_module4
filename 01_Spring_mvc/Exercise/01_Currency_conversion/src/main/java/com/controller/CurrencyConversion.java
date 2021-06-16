package com.controller;

import com.sevice.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    @Autowired
    IConvertService convertService;

    @GetMapping(value = "/")
public String convert(){
        return "index";
    }

    @PostMapping(value = "/convert")
    public String change(@RequestParam double input, double m1, double m2, Model model){
        double result = convertService.change(input,m1,m2);
        model.addAttribute("result",result);
        return "index";
    }
}
