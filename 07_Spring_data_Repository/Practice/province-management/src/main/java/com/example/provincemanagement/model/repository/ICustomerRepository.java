package com.example.provincemanagement.model.repository;

import com.example.provincemanagement.model.enttity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
