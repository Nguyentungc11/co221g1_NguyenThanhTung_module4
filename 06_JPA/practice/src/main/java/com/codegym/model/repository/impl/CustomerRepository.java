package com.codegym.model.repository.impl;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    EntityManager em;
    @Override
    public List<Customer> findAll() {
        return em.createQuery("SELECT c FROM Customer AS c",Customer.class).getResultList();
    }

    @Override
    public Customer findById(int id) {
        return em.find(Customer.class,id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        EntityTransaction entityTransaction = em.getTransaction();
        entityTransaction.begin();
        em.persist(customer);
    }

    @Override
    public void remove(int id) {

    }
}
