package com.example.employee.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ConsoleNotificationService implements NotificationService {

    @Override
    public void sendNotification(String message) {

        System.out.println("========== DEV NOTIFICATION ==========");
        System.out.println(message);
        System.out.println("======================================");

    }
}