package com.example.studentmanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(
		title = "Student Management API",
		version = "1.0",
		description = "CRUD operations for student records"
))

@SpringBootApplication
public class StudentmanagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}
}
