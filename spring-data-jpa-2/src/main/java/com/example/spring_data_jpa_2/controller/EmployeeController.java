package com.example.spring_data_jpa_2.controller;


import com.example.spring_data_jpa_2.model.Employee;
import com.example.spring_data_jpa_2.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/above-average")
    public ResponseEntity<List<Employee>> getEmployeesAboveAverage() {
        return ResponseEntity.ok(service.getEmployeesAboveAverageSalary());
    }

    @PutMapping("/update-salary")
    public ResponseEntity<String> updateSalary(@RequestParam Double salary) {
        int count = service.updateSalary(salary);
        return ResponseEntity.ok(count + " employees updated");
    }

    @DeleteMapping("/delete-min-salary")
    public ResponseEntity<String> deleteMinSalaryEmployees() {
        int count = service.deleteMinSalaryEmployees();
        return ResponseEntity.ok(count + " employees deleted");
    }
}