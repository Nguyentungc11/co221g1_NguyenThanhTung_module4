package com.model.service;

import com.model.bean.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    Product findById(int id);
    void upDate(int id,Product product);
    void remove(int id );
}
