package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final NotificationService notificationService;

    @Value("${application.name}")
    private String applicationName;

    public EmployeeService(EmployeeRepository employeeRepository,
                           NotificationService notificationService) {
        this.employeeRepository = employeeRepository;
        this.notificationService = notificationService;
    }

    @PostConstruct
    public void initialize() {
        System.out.println("========================================");
        System.out.println(applicationName + " started successfully.");
        System.out.println("========================================");
    }

    public void registerEmployee() {

        Employee employee = new Employee(
                101,
                "Darvin",
                "Backend Development"
        );

        employeeRepository.save(employee);

        notificationService.sendNotification(
                "Employee '" + employee.getName() + "' registered successfully."
        );
    }

    @PreDestroy
    public void destroy() {
        System.out.println("========================================");
        System.out.println(applicationName + " is shutting down...");
        System.out.println("Resources released successfully.");
        System.out.println("========================================");
    }
}