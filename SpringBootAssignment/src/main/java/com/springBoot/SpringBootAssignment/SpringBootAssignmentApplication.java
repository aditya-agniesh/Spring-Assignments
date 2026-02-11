package com.springBoot.SpringBootAssignment;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAssignmentApplication {

	@Value("${app.name}")
	private String name;

	@Value("${app.version}")
	private String version;


	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentApplication.class, args);
	}

	@PostConstruct
	public void display(){
		System.out.println("App Name: "+ name);
		System.out.println("App Version: "+ version);
	}
}
