package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {
    @RequestMapping(value = "/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/save")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        String result = "";
        if (condiment == null){
            result = "You don't choose sandwich ";
        }
        for (String temp : condiment) {
            if (temp != null) {
                result += temp + " ";
            }
        }
        if ("".equals(result)) {
            result = "You don't choose condiments for sandwich";
        }
        model.addAttribute("result", result);
        return "result";
    }
}
