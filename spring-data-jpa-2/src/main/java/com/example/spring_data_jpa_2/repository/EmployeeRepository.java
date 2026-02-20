package com.example.spring_data_jpa_2.repository;



import com.example.spring_data_jpa_2.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("""
       SELECT e
       FROM Employee e
       WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)
       ORDER BY e.age ASC, e.salary DESC
       """)
    List<Employee> findEmployeesWithSalaryGreaterThanAverage();



    @Modifying
    @Query("""
           UPDATE Employee e
           SET e.salary = :newSalary
           WHERE e.salary < (SELECT AVG(e2.salary) FROM Employee e2)
           """)
    int updateSalaryLessThanAverage(@Param("newSalary") Double newSalary);


    @Modifying
    @Query("""
           DELETE FROM Employee e
           WHERE e.salary = (SELECT MIN(e2.salary) FROM Employee e2)
           """)
    int deleteEmployeesWithMinimumSalary();
}