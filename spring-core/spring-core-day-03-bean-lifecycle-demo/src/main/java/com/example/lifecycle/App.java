package com.example.lifecycle;

import com.example.lifecycle.component.Engine;
import com.example.lifecycle.config.AppConfig;
import com.example.lifecycle.service.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        VehicleService vehicleService = context.getBean(VehicleService.class);
        vehicleService.startJourney();

        Engine engine1 = context.getBean(Engine.class);
        Engine engine2 = context.getBean(Engine.class);

        System.out.println();
        System.out.println("Same Engine Instance: " + (engine1 == engine2));

        context.close();
    }
}