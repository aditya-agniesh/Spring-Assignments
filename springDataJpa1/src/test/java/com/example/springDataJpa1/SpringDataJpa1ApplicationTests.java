package com.example.springDataJpa1;

import com.example.springDataJpa1.model.Employee;
import com.example.springDataJpa1.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootTest
class SpringDataJpa1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	EmployeeRepository employeeRepository;
	@Test
	public void testCreateEmployee(){
		Employee employee=new Employee();
		employee.setName("Aditya Agniesh");
		employee.setAge(21);
		employee.setLocation("noida");

		employeeRepository.save(employee);
	}

	@Test
	public void testUpdateEmployee(){
		Employee employee=employeeRepository.findById(1L).get();

		employee.setName("Rohit");
		employee.setAge(20);
		employee.setLocation("ttn");

		employeeRepository.save(employee);
	}

	@Test
	public void testDeleteEmployee() {
		if(employeeRepository.existsById(1L)){
			employeeRepository.deleteById(1L);
		}else
			System.out.println("id not found");
	}

	@Test
	public void testFindAllById(){
		employeeRepository.findAll().forEach(e-> System.out.println(e.getName()));
	}

	@Test
	public void testCountTotalEmployee(){
		long count = employeeRepository.count();
		System.out.println(count);
	}

	@Test
	public void testFindUserBYName(){
		employeeRepository.findByName("Dhawal").forEach(System.out::println);
	}

	@Test
	public void testNameStartsWith(){
		employeeRepository.findByNameStartsWith("A").forEach(System.out::println);
	}

	@Test
	public void testFindEmployeesBetween(){
		employeeRepository.findEmployeeByAgeIsBetween(28,32)
				.forEach(System.out::println);
	}

//	@Test
//	public void testEmployeeUsingPaging(){
//		Pageable pageable= PageRequest.of(0,2);
//		employeeRepository.findByAge(pageable).forEach(System.out::println);
//
//	}
}

