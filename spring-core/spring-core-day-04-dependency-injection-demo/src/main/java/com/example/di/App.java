package com.example.di;

import com.example.di.config.AppConfig;
import com.example.di.service.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        VehicleService vehicleService =
                context.getBean(VehicleService.class);

        vehicleService.startJourney();

        context.close();
    }
}