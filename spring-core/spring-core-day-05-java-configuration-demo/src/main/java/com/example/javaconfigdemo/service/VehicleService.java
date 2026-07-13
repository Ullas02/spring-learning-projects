package com.example.javaconfigdemo.service;

import com.example.javaconfigdemo.component.Car;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private final Car car;

    public VehicleService(Car car) {
        this.car = car;
    }

    public void startJourney() {
        car.drive();
    }
}