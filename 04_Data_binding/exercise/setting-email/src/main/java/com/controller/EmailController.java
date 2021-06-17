package com.controller;

import com.model.bean.Email;
import com.model.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    IEmailService emailService;

    @GetMapping("/")
    public String toHome(Model model) {
        List<String> listLanguage = this.emailService.getListLanguage();
        List<Integer> listPageSize = this.emailService.getListPageSize();
        model.addAttribute("email", new Email());

        model.addAttribute("listLanguage", listLanguage);
        model.addAttribute("listPageSize", listPageSize);
        return "index";
    }
    @PostMapping(value = "/email")
    public ModelAndView view(@ModelAttribute Email email){
//        return new ModelAndView("view","email",email);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("email",email);
        return modelAndView;
    }
}
