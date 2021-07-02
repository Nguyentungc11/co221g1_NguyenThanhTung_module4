package com.example.model.service;

import com.example.model.entity.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
    Iterable<SmartPhone> findAll();
    Optional<SmartPhone> findById(long id);
    SmartPhone save(SmartPhone smartPhone);
    void remove(long id);
}
