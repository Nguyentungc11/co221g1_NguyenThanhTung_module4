package com.controller;

import com.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService calculatorService;

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping(value = "/calculator")
    public String calculator(@RequestParam double num1, double num2, String calculator, Model model) {
        String result = calculatorService.calculator(num1, num2, calculator);
        model.addAttribute("result", result);
        return "index";
    }
}
