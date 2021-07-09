package com.example.model.service;

import com.example.model.entity.customer.Customer;
import com.example.model.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllByName(Pageable pageable,String keyword);


    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    List<CustomerType> listCustomerType();

}
