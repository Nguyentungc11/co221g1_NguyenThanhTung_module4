package com.codegym.controller;

import com.codegym.model.entity.Customer;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@org.springframework.stereotype.Controller
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping(value = "/")
    public String showListCustomer(Model model){
        List<Customer> list = iCustomerService.findAll();
        model.addAttribute("listCustomer",list);
        return "/index";
    }

    @GetMapping(value = "/show_create")
    public String showFormCreate(Model model){
        model.addAttribute("customer",new Customer());
        return "/create";
    }

    @PostMapping(value = "/create")
        public String createCustomer(Customer customer, RedirectAttributes redirectAttributes){
this.iCustomerService.saveCustomer(customer);
redirectAttributes.addFlashAttribute("message","Customer " + customer.getName() + "was add");
return "redirect:/";
    }


}
