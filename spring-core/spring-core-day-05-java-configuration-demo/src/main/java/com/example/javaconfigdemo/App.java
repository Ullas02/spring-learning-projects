package com.example.javaconfigdemo;

import com.example.javaconfigdemo.config.AppConfig;
import com.example.javaconfigdemo.service.NotificationService;
import com.example.javaconfigdemo.service.VehicleService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        VehicleService vehicleService =
                context.getBean(VehicleService.class);

        vehicleService.startJourney();

        NotificationService notificationService =
                context.getBean(NotificationService.class);

        notificationService.sendNotification();

        context.close();
    }
}