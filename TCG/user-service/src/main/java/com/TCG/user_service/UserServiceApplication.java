package com.TCG.user_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.TCG.user_service.service.UserService;
import com.TCG.user_service.model.User;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			userService.deleteAllUsers().subscribe();
			// Inserting users at startup
			userService.createUser(new User("john", "john@example.com", "123456")).subscribe();
			userService.createUser(new User("alice", "alice@example.com", "123456")).subscribe();
			userService.createUser(new User("bob", "bob@example.com", "123456")).subscribe();
		};
	}
}
