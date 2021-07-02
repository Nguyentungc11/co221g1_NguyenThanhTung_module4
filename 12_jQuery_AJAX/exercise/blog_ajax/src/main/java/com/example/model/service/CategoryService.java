package com.example.model.service;

import com.example.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    void  save(Category category);
    void deleteById(Integer id);
    Category findById(Integer id);
}
