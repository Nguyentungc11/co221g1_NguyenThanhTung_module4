package com.example.model.repository;

import com.example.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findAllCategory_Name(String name, Pageable pageable);
    List<Blog> findBlogByNameContaining(String name);

    @Query(value="select * from blog limit ?1",nativeQuery = true)
    List<Blog> getBlogList(Integer quantity);
}
