package com.example.model.service;

import com.example.model.entity.Customer;
import jdk.nashorn.internal.runtime.options.Option;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
List<Customer> findAll();
void save(Customer customer);
 Customer findById(Integer id) throws Exception;
}
