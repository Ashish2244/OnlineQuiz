package com.quiz.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.model.Role;
import com.quiz.model.User;
import com.quiz.model.UserRole;
import com.quiz.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) throws Exception {

		user.setProfile("default.png");
		user.setPassword("abc");

		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Admin");

		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);

		Set<UserRole> userSet = new HashSet<>();
		userSet.add(userRole);

		return this.userService.createUser(user, userSet);

	}

	@GetMapping("/getUser/{username}")
	public User getUser(@PathVariable("username") String username) {
		return userService.getUser(username);
	}

	@DeleteMapping("/deleteUserByUsername/{username}")
	public String deleteUserByUsername(@PathVariable("username") String username) {
		userService.deleteUserByName(username);
		return username;
	}

	@DeleteMapping("/deleteUserById/{userId}")
	public String deleteUserById(@PathVariable("userId") Long userId) {
		User user = userService.getUser(userId);
		userService.deleteUserById(userId);
		return user.getUsername();
	}

}
