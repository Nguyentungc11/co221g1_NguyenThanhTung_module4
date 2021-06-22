package com.codegym.model.repository.impl;

import com.codegym.model.entity.Product;
import com.codegym.model.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> findAll() {
        return BaseRepository.entityManager.createQuery("select p from Product as p",Product.class).getResultList();
    }

    @Override
    public Product findById(int id) {
        return BaseRepository.entityManager.find(Product.class,id);
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {

    }
}
