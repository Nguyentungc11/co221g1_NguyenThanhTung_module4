package com.example.model.entity.servcie;

import javax.persistence.*;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double are;
    private double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String otherConvenience;
    private double poolArea;
    private Integer numberFloor;
    @ManyToOne
    private RentType rentType;
    @ManyToOne
    private ServiceType serviceType;
}
