package com.example.employee;

import com.example.employee.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.getEnvironment().setActiveProfiles("dev");

        context.register(AppConfig.class);

        context.refresh();

        EmployeeService employeeService =
                context.getBean(EmployeeService.class);

        employeeService.registerEmployee();

        context.close();
    }
}