package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

    public void save(Employee employee) {

        System.out.println("========================================");
        System.out.println("Saving employee...");
        System.out.println(employee);
        System.out.println("Employee saved successfully.");
        System.out.println("========================================");

    }

}