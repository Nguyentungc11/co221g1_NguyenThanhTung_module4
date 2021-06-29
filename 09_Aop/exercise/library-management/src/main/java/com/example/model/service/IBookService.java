package com.example.model.service;

import com.example.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    void save(Book book);
}
