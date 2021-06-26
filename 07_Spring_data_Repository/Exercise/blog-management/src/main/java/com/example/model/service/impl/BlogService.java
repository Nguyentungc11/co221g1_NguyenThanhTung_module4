package com.example.model.service.impl;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import com.example.model.repository.IBlogRepository;
import com.example.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
if (findById(blog.getId()) == null){
    blog.setAuthor("Admin");
    blog.setDate(new Date(new java.util.Date().getTime()));
}
iBlogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchInTitle(String title, Pageable pageable) {
        return iBlogRepository.findByTitleContaining(title,pageable);
    }

    @Override
    public Page<Blog> findByCategory(Category category, Pageable pageable) {
        return iBlogRepository.findByCategory(category, pageable);
    }

    @Override
    public Page<Blog> sortByTitleDesc(Pageable pageable) {
        return iBlogRepository.findByOrderByTitleDesc(pageable);
    }
}
