package com.example.controller;

import com.example.model.entity.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("counter")
public class CounterController {
    @ModelAttribute("counter")
    public Counter setupCounter(){
        return new Counter();
    }
    @GetMapping(value = "/")
    public String get(@ModelAttribute Counter counter){
        counter.increment();
        return "index";
    }
}
