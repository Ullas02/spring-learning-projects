package com.example.javaconfigdemo.service;

import com.example.javaconfigdemo.thirdparty.NotificationClient;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification() {
        notificationClient.send("Welcome to Spring!");
    }
}