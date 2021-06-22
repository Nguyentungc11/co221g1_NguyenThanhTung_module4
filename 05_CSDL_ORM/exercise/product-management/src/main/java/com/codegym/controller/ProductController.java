package com.codegym.controller;

import com.codegym.model.entity.Product;
import com.codegym.model.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"", "/product"})
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping(value = "")
    public String goToListProduct(Model model) {
        model.addAttribute("listProduct", this.iProductService.findAll());
        return "index";
    }
    @GetMapping(value = "/show_create")
    public String showCreate(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping(value = "/create")
    public String createProduct(Product product, RedirectAttributes redirectAttributes){
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("message","Product " + product.getName() + "was add");
        return "redirect:/product/";
    }
    @GetMapping(value = "/view")
    public String viewProduct(@RequestParam int id,Model model){
        model.addAttribute("product",iProductService.findById(id));
        return "view";
    }

}
