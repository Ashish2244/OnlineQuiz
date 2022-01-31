package com.quiz;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.quiz.model.Role;
import com.quiz.model.User;
import com.quiz.model.UserRole;
import com.quiz.services.UserService;

@SpringBootApplication
public class QuizApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * User user=new User(); user.setFirstName("Ashish");
		 * user.setLastName("Gunjan"); user.setUsername("ashishgunjan");
		 * user.setPassword("abc"); user.setEmail("abc@gmail.com");
		 * user.setProfile("default.png");
		 * 
		 * Role role =new Role(); role.setRoleId(44L); role.setRoleName("Admin");
		 * 
		 * 
		 * UserRole userRole=new UserRole(); userRole.setRole(role);
		 * userRole.setUser(user);
		 * 
		 * Set<UserRole> userSet=new HashSet<>(); userSet.add(userRole);
		 * 
		 * User userGet=this.userService.createUser(user, userSet);
		 * System.out.println("Name "+userGet.getFirstName());
		 */
		System.out.println("Server Started");
	}

}
