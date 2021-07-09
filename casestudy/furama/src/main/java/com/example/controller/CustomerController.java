package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.entity.customer.Customer;
import com.example.model.entity.customer.CustomerType;
import com.example.model.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(value = {"/customer"})
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @ModelAttribute("customerTypes")
    public List<CustomerType> customerTypeList(){
        return iCustomerService.listCustomerType();
    }
    @GetMapping(value = {"/list",""})
    public String gotoListCustomer(@PageableDefault(value = 2) Pageable pageable, Model model,
                                   @RequestParam Optional<String> keyword) {
        String keywordValue = "";
        if (keyword.isPresent()){
            keywordValue = keyword.get();
        }
        Page<Customer> customerList = iCustomerService.findAllByName(pageable,keywordValue);
        model.addAttribute("customerList",customerList);
        model.addAttribute("keywordValue",keywordValue);
        return "customer/list";
    }
    @GetMapping(value = "/create")
    public String showFormCreate(Model  model){
        CustomerDto customerDto = new CustomerDto();
        model.addAttribute("customerDto",customerDto);
        return "customer/create";
    }
    @PostMapping(value = "/create")
    public String createCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "customer/create";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Create success");
        return "redirect:/customer/";
    }
    @GetMapping(value = "edit")
    public String showFormEdit(@RequestParam Integer id, Model model){
        Customer customer = iCustomerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        model.addAttribute("customerDto",customerDto);
        return "customer/edit";
    }
    @PostMapping(value = "edit")
    public String editCustomer(@Valid @ModelAttribute CustomerDto customerDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("msg","Edit success");
        return "redirect:/customer/";
    }
    @PostMapping(value = "delete")
    public String deleteCustomer(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        iCustomerService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete success");
        return "redirect:/customer/";
    }
}
