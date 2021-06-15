package com.sevice.impl;

import com.sevice.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double change(double a, double b, double c) {
        return a*c/b;
    }
}
