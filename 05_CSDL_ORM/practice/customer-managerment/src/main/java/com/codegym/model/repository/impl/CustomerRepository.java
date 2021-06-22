package com.codegym.model.repository.impl;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> findAll() {
        return BaseRepository.entityManager.createQuery("SELECT c FROM Customer AS c",Customer.class).getResultList();
    }

    @Override
    public Customer findOne(Long id) {
        return BaseRepository.entityManager.find(Customer.class,id);
    }

    @Override
    public void save(Customer customer) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(customer);
    }

    @Override
    public void upDate(long id, Customer customer) {

    }

    @Override
    public void remove(long id) {

    }
}
