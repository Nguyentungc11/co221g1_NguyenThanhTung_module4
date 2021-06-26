package com.example.controller;

import com.example.model.entity.Category;
import com.example.model.service.IBlogService;
import com.example.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    ICategoryService iCategoryService;
    @GetMapping
    public String listCategories(@PageableDefault(value = 2) Pageable pageable, Model model) {
        model.addAttribute("categories", iCategoryService.findAll(pageable));
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("category", new Category());
        return "category/list";
    }

    @GetMapping("/save")
    public String save(Category category, RedirectAttributes redirect) {
        iCategoryService.save(category);
        redirect.addFlashAttribute("message", "Saved category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("category", iCategoryService.findById(id));
        return "category/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
        iCategoryService.remove(id);
        redirect.addFlashAttribute("message", "Removed category successfully!");
        return "redirect:/category";
    }



    @GetMapping("/blogs")
    public String view(@RequestParam Integer id, @PageableDefault(value = 2) Pageable pageable, Model model) {
        Category category = iCategoryService.findById(id);
        model.addAttribute("categoryList", iCategoryService.findAll());
        model.addAttribute("category", category);
        model.addAttribute("blogs", iBlogService.findByCategory(category, pageable));
        return "category/view";
    }
}
