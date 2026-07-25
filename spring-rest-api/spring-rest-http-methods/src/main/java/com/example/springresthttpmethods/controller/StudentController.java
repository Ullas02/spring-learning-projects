package com.example.springresthttpmethods.controller;

import com.example.springresthttpmethods.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {

        return new Student(
                1,
                "Darvin",
                "Spring Boot"
        );

    }

}
