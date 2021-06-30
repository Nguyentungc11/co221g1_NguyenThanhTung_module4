package com.example.model.service;

import com.example.model.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Integer id);
    void save(Blog blog);
    void deleteById(Integer id);
}
