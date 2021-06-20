package com.model.repository.impl;

import com.model.bean.Product;
import com.model.repository.IProductRepository;

import java.util.*;

public class ProductRepository implements IProductRepository {
private static Map<Integer,Product> productMap;
static {
    productMap = new HashMap<>();
    productMap.put(1,new Product(1,"iphone1",1000,"cui bap","apple"));
    productMap.put(2,new Product(2,"iphone2",2000,"hoi cui bap","apple"));
    productMap.put(3,new Product(3,"iphone3",3000," het cui bap","apple"));
    productMap.put(4,new Product(4,"iphone4",4000,"xin","apple"));
    productMap.put(5,new Product(5,"iphone5",5000,"dang cap","apple"));
}
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
productMap.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void upDate(int id, Product product) {
productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
productMap.remove(id);
    }
}
