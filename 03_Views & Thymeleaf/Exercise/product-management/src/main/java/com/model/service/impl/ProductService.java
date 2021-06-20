package com.model.service.impl;

import com.model.bean.Product;
import com.model.repository.IProductRepository;
import com.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void upDate(int id, Product product) {
productRepository.upDate(id,product);
    }

    @Override
    public void remove(int id) {
productRepository.remove(id);
    }
}
