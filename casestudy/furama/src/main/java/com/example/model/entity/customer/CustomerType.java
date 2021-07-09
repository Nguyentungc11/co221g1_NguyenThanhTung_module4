package com.example.model.entity.customer;

import com.example.model.entity.customer.Customer;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    private String typeName;
    @OneToMany(mappedBy = "customerType")
    List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(Integer typeId, String typeName, List<Customer> customers) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.customers = customers;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
