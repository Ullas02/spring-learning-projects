package com.example.lifecycle.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class DatabaseManager {

    @PostConstruct
    public void connect() {
        System.out.println("[Database] Connected");
    }

    @PreDestroy
    public void disconnect() {
        System.out.println("[Database] Disconnected");
    }
}