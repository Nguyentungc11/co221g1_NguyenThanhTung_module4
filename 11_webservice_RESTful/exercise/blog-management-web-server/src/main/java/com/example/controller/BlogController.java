package com.example.controller;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/blog")
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping
    public String showList(Model model) {
        List<Blog> blogs = iBlogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blog/list";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        List<Category> categories = iCategoryService.findAll();
        Blog blog = new Blog();
        model.addAttribute("blog", blog);
        model.addAttribute("categories", categories);
        return "blog/create";
    }

    @PostMapping(value = "/create")
    public String createNewBlog(@ModelAttribute Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blog";
    }
}
