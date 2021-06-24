package com.example.provincemanagement.controller;

import com.example.provincemanagement.model.enttity.Customer;
import com.example.provincemanagement.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping(value = "/list")
    public String showListCustomer(Model model){
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "customer/list";
    }
    @GetMapping(value = "/create")
    public String showCreateCustomer(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "customer/create";
    }
    @PostMapping(value = "/create")
    public String createProduct(Customer customer, RedirectAttributes redirectAttributes){
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Customer " + customer.getFistName() + "was add");
        return "redirect:/customer/list";
    }
}
