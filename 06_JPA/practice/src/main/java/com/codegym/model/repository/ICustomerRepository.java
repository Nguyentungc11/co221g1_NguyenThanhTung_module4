package com.codegym.model.repository;

import com.codegym.model.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
    Customer findById(int id);
    void saveCustomer(Customer customer);
    void remove(int id);
}
