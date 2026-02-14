package com.restful.WebServiceAssignment.controller;

import com.restful.WebServiceAssignment.exceptions.EmployeeNotFoundException;
import com.restful.WebServiceAssignment.model.Employee;
import com.restful.WebServiceAssignment.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


    private EmployeeService employeeService;

    EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/showAll")
    public ResponseEntity<List<Employee>> getAllEmployee(){
      List<Employee> employees=  employeeService.findAllEmployee();
      return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id){
        Employee employee=employeeService.findById(id);
//        if(employee==null){
//            throw new EmployeeNotFoundException("User not found with id : "+id);
//        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

//    @PostMapping("/add")
//    public void addEmployee(@RequestBody Employee employee){
//        employeeService.save(employee);
//
//    }

    @PostMapping("/add")
    public ResponseEntity<String> addEmployee( @RequestBody @Valid Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>("Employee added sucessfully",HttpStatus.CREATED);
    }

//    @PostMapping("/add")
//    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
//        Employee savedEmployee=employeeService.save(employee);
//        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        boolean isDeleted=employeeService.deleteById(id);
        if(isDeleted) {
            return new ResponseEntity<>("Employee deleted with id: " + id, HttpStatus.OK);
        }
        return new ResponseEntity<>("Employee not found",HttpStatus.NOT_FOUND);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id,
                                 @Valid @RequestBody Employee employee){

        Employee update=employeeService.update(id,employee);
        if(update != null){
            return ResponseEntity.ok(update);
        }
        return ResponseEntity.noContent().build();
    }

}
