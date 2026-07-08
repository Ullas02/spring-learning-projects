package com.example.di.service;

import com.example.di.component.Car;
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