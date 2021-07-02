package com.example.controller;

import com.example.model.entity.Category;
import com.example.model.service.BlogService;
import com.example.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    private Integer noRecord = 2;
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;
    @ModelAttribute("categories")
    public List<Category> getCategories(){
        return categoryService.findAll();
    }

    @GetMapping
    public ModelAndView showHomePage(){
        return new ModelAndView("/homepage","blogs",blogService.findAll(2));
    }

    @GetMapping("/search/{nameBlog}")
    public ModelAndView showSearchList(@PathVariable String nameBlog){
        if("".equals(nameBlog)){
            return new ModelAndView("/blog/search","blogs",blogService.findAll(2));
        }
        return new ModelAndView("/blog/search","blogs",blogService.findAllBlogByName(nameBlog));
    }

    @GetMapping("/more-blog")
    public ModelAndView getMore(){
        noRecord += 2;
        return new ModelAndView("/blog/more","blogs",blogService.findAll(noRecord));
    }
}
