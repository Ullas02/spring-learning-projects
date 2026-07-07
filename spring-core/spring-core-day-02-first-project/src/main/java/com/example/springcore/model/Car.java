package com.example.springcore.model;

import org.springframework.stereotype.Component;

@Component
public class Car {

    private final Engine engine;
    private final MusicSystem musicSystem;

    public Car(Engine engine, MusicSystem musicSystem) {
        this.engine = engine;
        this.musicSystem = musicSystem;
    }

    public void drive() {
        engine.start();
        musicSystem.play();
        System.out.println("Car is moving...");
    }
}