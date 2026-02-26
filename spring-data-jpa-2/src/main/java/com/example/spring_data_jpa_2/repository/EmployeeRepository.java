package com.example.spring_data_jpa_2.repository;

import com.example.spring_data_jpa_2.model.Employee;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("""

            SELECT e.firstName, e.lastName
           FROM Employee e
           WHERE e.salary > (SELECT AVG(e2.salary) FROM Employee e2)
           ORDER BY e.age ASC, e.salary DESC
           """)
    List<Object[]> findNamesAboveAverageSalaryJPQL();

    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double findAverageSalary();


    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :newSalary WHERE e.salary < :avgSalary")
    int updateSalaryBelowAverage(@Param("newSalary") Double newSalary,
                                 @Param("avgSalary") Double avgSalary);

    @Query("SELECT MIN(e.salary) FROM Employee e")
    Double findMinimumSalary();

    @Modifying
    @Transactional
    @Query("DELETE FROM Employee e WHERE e.salary = :minSalary")
    int deleteBySalary(@Param("minSalary") Double minSalary);



    @Query(value = """
            SELECT id, first_name, age
            FROM employee_table
            WHERE last_name LIKE %:lastName
            """, nativeQuery = true)
    List<Object[]> findEmployeesByLastNameEndingWithNative(@Param("lastName") String lastName);


    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM employee_table
            WHERE age > :age
            """, nativeQuery = true)
    int deleteEmployeesByAgeNative(@Param("age") Integer age);

}