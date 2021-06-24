package com.example.provincemanagement.model.enttity;

import javax.persistence.*;

@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fistName;
    private String lastName;
    @ManyToOne
            @JoinColumn(name = "p_id")
    Province province;

    public Customer() {
    }

    public Customer(String fistName, String lastName, Province province) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.province = province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }
}
