package com.example.controller;

import com.example.dto.UserDto;
import com.example.model.entity.User;
import com.example.model.service.IUserService;
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

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @GetMapping(value = "/")
    public String goToFormCreate(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "form_login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute @Valid UserDto userDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes,
                            Model model) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("user",userDto);
            return "form_login";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        iUserService.save(user);
        model.addAttribute("user",user);
//        redirectAttributes.addFlashAttribute("message", "Create new successfully!");
        return "result";
    }
}
