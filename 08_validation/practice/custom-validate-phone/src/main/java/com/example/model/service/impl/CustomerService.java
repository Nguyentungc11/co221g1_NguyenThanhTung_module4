package com.example.model.service.impl;

import com.example.model.entity.Customer;
import com.example.model.repository.ICustomerRepository;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }
}
