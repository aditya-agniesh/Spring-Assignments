package com.example.spring_data_jpa_2.service;

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

    //JPQL

    public List<Object[]> getNamesAboveAverageSalaryJPQL() {
        return repository.findNamesAboveAverageSalaryJPQL();
    }

    public int updateSalaryBelowAverage(Double newSalary) {
        Double avg = repository.findAverageSalary();
        return repository.updateSalaryBelowAverage(newSalary, avg);
    }


    @Transactional
    public int deleteEmployeesWithMinSalary() {
        Double minSalary = repository.findMinimumSalary();
        return repository.deleteBySalary(minSalary);
    }

    //NATIVE

    public List<Object[]> getEmployeesByLastNameNative(String lastName) {
        return repository.findEmployeesByLastNameEndingWithNative(lastName);
    }

    public int deleteEmployeesByAgeNative(Integer age) {
        return repository.deleteEmployeesByAgeNative(age);
    }

}