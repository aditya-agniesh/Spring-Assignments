package com.restful.WebServiceAssignment.service;

import com.restful.WebServiceAssignment.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    static int count=1;
    private static List<Employee> employeeList=new ArrayList<>();

    static {
        employeeList.add(new Employee(count++,"Aditya Agniesh", 21));
        employeeList.add(new Employee(count++,"Saumyajeet Kumar", 22));
        employeeList.add(new Employee(count++,"Aditi", 23));
    }

    public List<Employee> findAllEmployee(){
        return employeeList;
    }

    public Employee findById(int id){
        return employeeList.stream().filter(emp->emp.getId()==id).findFirst().orElse(null);
    }

    public void save(Employee employee){
        employee.setId(++count);
        employeeList.add(employee);
    }

//    public Employee save(Employee employee){
//        employee.setId(++count);
//        employeeList.add(employee);
//        return employee;
//    }

    public boolean deleteById(int id){
       return employeeList.removeIf(emp->emp.getId()==id);
    }

    public Employee update(int id, Employee updatedEmployee){
        Employee employee=
                employeeList.stream()
                        .filter(emp->emp.getId()==id)
                        .findFirst().orElse(null);

        if(employee != null){
            employee.setName(updatedEmployee.getName());
            employee.setAge(updatedEmployee.getAge());
        }
        return employee;
    }
}
