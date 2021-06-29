package com.example.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "provinces")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
    private String name;

    @OneToMany(mappedBy = "province")
    private List<Customer> customer;

    public Province() {
    }

    public Province(Integer id, String name, List<Customer> customer) {
        this.id = id;
        this.name = name;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
