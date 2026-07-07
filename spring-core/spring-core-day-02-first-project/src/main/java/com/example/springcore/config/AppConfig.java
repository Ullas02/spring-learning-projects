package com.example.springcore.config;

import com.example.springcore.model.Car;
import com.example.springcore.model.Engine;
import com.example.springcore.model.MusicSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.springcore")
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine();
    }

    @Bean
    public MusicSystem musicSystem(){
        return new MusicSystem();
    }

    @Bean
    public Car car() {
        return new Car(engine(), musicSystem());
    }
}