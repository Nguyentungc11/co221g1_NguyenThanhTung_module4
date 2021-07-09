package com.example.model.repository;

import com.example.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value="select * from customer where (flag = 1 and `name` like :nameSearch)",nativeQuery = true)
    Page<Customer> findAllByNameContaining(Pageable pageable,@Param("nameSearch") String keyword);

}
