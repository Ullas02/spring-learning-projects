package config;

import model.Car;
import model.Engine;
import model.MusicSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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