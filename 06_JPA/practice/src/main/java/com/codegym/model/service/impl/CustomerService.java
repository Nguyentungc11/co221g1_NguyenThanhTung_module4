package com.codegym.model.service.impl;

import com.codegym.model.entity.Customer;
import com.codegym.model.repository.ICustomerRepository;
import com.codegym.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
iCustomerRepository.saveCustomer(customer);
    }

    @Override
    public void remove(int id) {

    }
}
