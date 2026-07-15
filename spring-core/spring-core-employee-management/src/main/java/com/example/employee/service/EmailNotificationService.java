package com.example.employee.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class EmailNotificationService implements NotificationService {

    @Override
    public void sendNotification(String message) {

        System.out.println("========== EMAIL NOTIFICATION ==========");
        System.out.println("Sending email...");
        System.out.println("Message : " + message);
        System.out.println("Email sent successfully.");
        System.out.println("========================================");

    }
}