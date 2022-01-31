package com.quiz.services;

import java.util.List;
import java.util.Set;

import com.quiz.exception.UserFoundException;
import com.quiz.model.User;
import com.quiz.model.UserRole;

public interface UserService {

	public User createUser(User user, Set<UserRole> userRole) throws UserFoundException;

	public User getUser(String username);
	
	public User getUser(Long userId);

	public void deleteUserByName(String username);

	public void deleteUserById(Long userId);
}
