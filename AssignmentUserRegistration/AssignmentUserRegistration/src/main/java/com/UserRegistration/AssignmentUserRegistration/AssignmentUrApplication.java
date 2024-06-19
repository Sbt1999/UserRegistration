package com.UserRegistration.AssignmentUserRegistration;

import com.UserRegistration.AssignmentUserRegistration.DTOs.UserRegistrationRequestDTO;
import com.UserRegistration.AssignmentUserRegistration.controller.UserController;
import com.UserRegistration.AssignmentUserRegistration.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
//public class AssignmentUrApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(AssignmentUrApplication.class, args);
//	}
//
//}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentUrApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private UserController userController;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentUrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add test users
		addUser("Alice", "alice@example.com", "Password1!");
		addUser("Bob", "bob@example.com", "Password1!");
		addUser("Charlie", "charlie@example.com", "Password1!");
		addUser("David", "david@example.com", "Password1!");
		addUser("Eve", "eve@example.com", "Password1!");
	}

	private void addUser(String name, String email, String password) {
		UserRegistrationRequestDTO requestDTO = new UserRegistrationRequestDTO();
		requestDTO.setName(name);
		requestDTO.setEmail(email);
		requestDTO.setPassword(password);

		userController.signUp(requestDTO);
	}
}

