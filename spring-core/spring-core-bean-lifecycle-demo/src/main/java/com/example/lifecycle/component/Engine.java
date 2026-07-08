package com.example.lifecycle.component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Engine {

    public Engine() {
        System.out.println("[Engine] Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("[Engine] Initialized");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[Engine] Destroyed");
    }

    public void start() {
        System.out.println("[Engine] Starting...");
    }
}