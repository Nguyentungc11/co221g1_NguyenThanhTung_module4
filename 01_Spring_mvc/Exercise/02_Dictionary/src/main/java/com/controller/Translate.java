package com.controller;

import com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Translate {
    @Autowired
    IDictionaryService dictionaryService;
    @GetMapping
    public String home(){
        return "index";
    }

    @PostMapping("/translate")
    public String translate(@RequestParam String nhap, Model model){
        String result = dictionaryService.translate(nhap);
        model.addAttribute("result",result);
        return "index";
    }

}
