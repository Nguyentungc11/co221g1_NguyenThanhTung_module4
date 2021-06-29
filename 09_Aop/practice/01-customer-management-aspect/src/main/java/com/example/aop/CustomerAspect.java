package com.example.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CustomerAspect {


    @AfterThrowing(pointcut = "execution(public * com.example.model.service.impl.CustomerService.*(..))")
    public void log() {
        System.err.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}

