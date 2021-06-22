package com.codegym.model.service;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findOne(Long id);
    void save(Customer customer);
    void upDate(long id,Customer customer);
    void remove(long id);
}
