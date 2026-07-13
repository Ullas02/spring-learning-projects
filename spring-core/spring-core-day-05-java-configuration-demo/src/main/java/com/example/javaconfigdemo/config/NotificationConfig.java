package com.example.javaconfigdemo.config;

import com.example.javaconfigdemo.thirdparty.NotificationClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public NotificationClient notificationClient() {
        return new NotificationClient();
    }
}