package com.example.controller;

import com.example.model.entity.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping(value = "/")
    public String goHomePage(Model model) {
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping(value = "create")
    public String createNewCustomer(Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Customer " +
                customer.getName() + "was add");
        return "redirect:";
    }

    @GetMapping(value = "/view")
    public String viewCustomer(@RequestParam Integer id, Model model) {
        try {
            Customer customer = iCustomerService.findById(id);
            model.addAttribute("customer", customer);
            return "view";
        } catch (Exception e) {
            return "list";

        }
    }
}

