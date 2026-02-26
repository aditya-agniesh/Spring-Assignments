package com.example.ComponentMapping;

import com.example.ComponentMapping.model.Employee;
import com.example.ComponentMapping.model.Salary;
import com.example.ComponentMapping.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComponentMappingApplication implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;

	public ComponentMappingApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(ComponentMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Salary salary = new Salary(50000, 10000, 5000, 7000);

		Employee employee = new Employee(
				"Aditya",
				"Agniesh",
				24,
				salary
		);

		employeeRepository.save(employee);
	}
}
