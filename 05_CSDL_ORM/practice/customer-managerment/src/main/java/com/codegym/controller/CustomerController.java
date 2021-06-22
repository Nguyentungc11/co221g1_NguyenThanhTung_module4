package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping(value = "")
    public String showListCustomer(Model model){
        model.addAttribute("listCustomer",iCustomerService.findAll());
        return "list_customer";
    }

@PostMapping(value ="/show_info" )
    public String info(@RequestParam Long id, Model model){
        model.addAttribute("customer",iCustomerService.findOne(id));
        return "info";
}

}
