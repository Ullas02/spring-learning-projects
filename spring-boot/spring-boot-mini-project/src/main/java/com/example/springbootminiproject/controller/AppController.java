package com.example.springbootminiproject.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private static final Logger logger =
            LoggerFactory.getLogger(AppController.class);

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String version;

    @GetMapping("/")
    public String home() {

        logger.info("Home endpoint called");

        return "Welcome to Spring Boot!";
    }

    @GetMapping("/about")
    public String about() {

        logger.info("About endpoint called");

        return "Spring Boot Module 2 Mini Project";
    }

    @GetMapping("/config")
    public String config() {

        logger.info("Config endpoint called");

        return appName + " Version : " + version;
    }

    @GetMapping("/contact")
    public String contact() {

        logger.info("Contact endpoint called");

        return appName + " Version : " + version;
    }

}