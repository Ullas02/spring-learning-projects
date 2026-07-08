package com.example.lifecycle.component;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
        System.out.println("[Car] Constructor");
    }

    public void drive() {
        engine.start();
        System.out.println("[Car] Driving...");
    }
}