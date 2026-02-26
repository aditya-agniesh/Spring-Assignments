package com.example.spring_data_jpa_2.controller;

import com.example.spring_data_jpa_2.service.EmployeeService;
import com.example.spring_data_jpa_2.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/jpql/above-average")
    public List<Object[]> jpqlAboveAverage() {
        return service.getNamesAboveAverageSalaryJPQL();
    }

    @PutMapping("/jpql/update")
    public String updateJPQL(@RequestParam Double salary) {
        return service.updateSalaryBelowAverage(salary) + " updated";
    }

    @DeleteMapping("/jpql/min-salary")
    public String deleteJPQL() {
        return service.deleteEmployeesWithMinSalary() + " deleted";
    }


    @GetMapping("/native/lastname")
    public List<Object[]> nativeLastName(@RequestParam String lastName) {
        return service.getEmployeesByLastNameNative(lastName);
    }

    @DeleteMapping("/native/age")
    public String deleteNative(@RequestParam Integer age) {
        return service.deleteEmployeesByAgeNative(age) + " deleted";
    }

}