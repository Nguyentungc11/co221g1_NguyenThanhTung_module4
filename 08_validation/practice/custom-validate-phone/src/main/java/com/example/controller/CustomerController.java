package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.entity.Customer;
import com.example.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping(value = "/")
    public String goHomePage(Model model){
        List<Customer> customerList = iCustomerService.findAll();
        model.addAttribute("customers",customerList);
        return "home";
    }
    @GetMapping(value = "/create")
    public String goCreatePage(Model model){
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto",customerDto);
        return "create";
    }
    @PostMapping(value = "/create")
    public String createNewCustomer(@ModelAttribute @Valid CustomerDto customerDto, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes, Model model){
        customerDto.validate(customerDto,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("customers",this.iCustomerService.findAll());
            return "create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message","Create new successfully");
        return "redirect:";
    }
}
