package com.codegym.model.repository;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findOne(Long id);
    void save(Customer customer);
    void upDate(long id,Customer customer);
    void remove(long id);
}
