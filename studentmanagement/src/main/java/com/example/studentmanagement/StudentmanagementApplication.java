package com.example.studentmanagement;

import com.example.studentmanagement.model.Role;
import com.example.studentmanagement.model.Users;
import com.example.studentmanagement.model.Users;
import com.example.studentmanagement.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class StudentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			if (userRepository.findByUsername("admin").isEmpty()) {
				Users user = new Users();
				user.setUsername("admin");
				user.setPassword(encoder.encode("admin"));
				user.setRole(Role.ADMIN);
				userRepository.save(user);
			}
		};
	}
}
