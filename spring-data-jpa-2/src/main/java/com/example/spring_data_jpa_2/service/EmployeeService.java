package com.example.spring_data_jpa_2.service;



import com.example.spring_data_jpa_2.model.Employee;
import com.example.spring_data_jpa_2.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> getEmployeesAboveAverageSalary() {
        return repository.findEmployeesWithSalaryGreaterThanAverage();
    }

    @Transactional
    public int updateSalary(Double newSalary) {
        return repository.updateSalaryLessThanAverage(newSalary);
    }

    @Transactional
    public int deleteMinSalaryEmployees() {
        return repository.deleteEmployeesWithMinimumSalary();
    }
}