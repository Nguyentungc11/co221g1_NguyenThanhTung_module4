package com.example.provincemanagement.model.service;

import com.example.provincemanagement.model.enttity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
}
