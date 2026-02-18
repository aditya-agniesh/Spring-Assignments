package com.example.springDataJpa1.repository;

import com.example.springDataJpa1.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findByName(String name);

    List<Employee> findByNameStartsWith(String name);

    List<Employee> findEmployeeByAgeIsBetween(Integer ageAfter, Integer ageBefore);

    Page<Employee> findByAge(Pageable pageable, Integer age);

    List<Employee> findAllByAge( Integer age,Sort sort);
}
