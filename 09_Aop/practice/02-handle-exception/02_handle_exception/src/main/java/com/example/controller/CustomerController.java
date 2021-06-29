package com.example.controller;

import com.example.exception.EmailException;
import com.example.model.entity.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping(value = "/")
    public String goHomePage(Model model){
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customerList",customerList);
        return "list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model){
        Customer customer = new Customer();
        model.addAttribute("customer",customer);
        return "create";
    }
    @PostMapping(value = "create")
    public String createNewCustomer(Customer customer, RedirectAttributes redirectAttributes) throws EmailException {
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Customer " +
                customer.getName() + "was add");
        return "redirect:";
    }

    @ExceptionHandler(EmailException.class)
    public String showError(){
        return "error";
    }


    @GetMapping(value = "/view")
    public String viewCustomer(@RequestParam Integer id,Model model){
        Customer customer = iCustomerService.findById(id);
        model.addAttribute("customer",customer);
        return "view";
    }
//    try {
//        ModelAndView modelAndView = new ModelAndView("/customers/info");
//        Optional<Customer> customerOptional = customerService.findOne(id);
//        modelAndView.addObject("customer", customerOptional.get());
//        return modelAndView;
//    } catch (Exception e) {
//        return new ModelAndView("redirect:/customers");
//    }
}
