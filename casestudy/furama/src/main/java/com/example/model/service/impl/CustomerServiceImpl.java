package com.example.model.service.impl;

import com.example.model.entity.customer.Customer;
import com.example.model.entity.customer.CustomerType;
import com.example.model.repository.ICustomerRepository;
import com.example.model.repository.ICustomerTypeRepository;
import com.example.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllByName(Pageable pageable, String keyword) {

        return iCustomerRepository.findAllByNameContaining(pageable,"%" + keyword + "%");
    }

    @Override
    public Customer findById(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        Customer customer = this.findById(id);
        customer.setFlag(false);
        iCustomerRepository.save(customer);
    }

    @Override
    public List<CustomerType> listCustomerType() {
        return iCustomerTypeRepository.findAll();
    }
}
