package com.example.model.service;

import com.example.exception.EmailException;
import com.example.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
List<Customer> findAll();
void save(Customer customer) throws EmailException;
 Customer findById(Integer id);
}
