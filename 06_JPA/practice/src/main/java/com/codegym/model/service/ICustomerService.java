package com.codegym.model.service;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    void saveCustomer(Customer customer);
    void remove(int id);
}
