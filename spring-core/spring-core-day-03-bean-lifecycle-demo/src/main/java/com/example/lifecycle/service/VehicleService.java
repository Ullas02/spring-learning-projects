package com.example.lifecycle.service;

import com.example.lifecycle.component.Car;
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