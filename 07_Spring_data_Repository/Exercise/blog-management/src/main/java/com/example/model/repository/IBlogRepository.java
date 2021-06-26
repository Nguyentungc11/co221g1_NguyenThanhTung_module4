package com.example.model.repository;

import com.example.model.entity.Blog;
import com.example.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitleContaining(String title,Pageable pageable);
    Page<Blog> findByCategory(Category category,Pageable pageable);
    Page<Blog> findByOrderByTitleDesc(Pageable pageable);
}
