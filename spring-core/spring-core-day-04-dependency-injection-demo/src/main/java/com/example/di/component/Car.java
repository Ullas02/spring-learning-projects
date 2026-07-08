package com.example.di.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

    private Engine engine;

    public Car() {
        System.out.println("Car created.");
    }

    @Autowired
    public void setEngine(Engine engine) {
        this.engine = engine;
        System.out.println("Engine injected using Setter Injection.");
    }

    public void drive() {
        engine.start();
        System.out.println("Car is moving...");
    }
}