package com.codegym.model.repository;

import com.codegym.model.entity.Product;

import java.util.List;

public interface IProductRepository {
List<Product> findAll();
Product findById(int id);
void save(Product product);
void remove(int id);
}
