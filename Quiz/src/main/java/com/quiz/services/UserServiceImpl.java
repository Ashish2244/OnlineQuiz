package com.quiz.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.exception.UserFoundException;
import com.quiz.model.User;
import com.quiz.model.UserRole;
import com.quiz.repo.RoleRepository;
import com.quiz.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User createUser(User user, Set<UserRole> userRole) throws UserFoundException {

		User local = this.userRepository.findByUsername(user.getUsername());
		if (null != local)
			throw new UserFoundException("User is already present");
		else {
			for (UserRole role : userRole) {
				roleRepository.save(role.getRole());
			}
			user.getUserRoles().addAll(userRole);
			local = this.userRepository.save(user);
		}
		return local;
	}

	@Override
	public User getUser(String username) {
		return this.userRepository.findByUsername(username);
	}

	@Override
	public void deleteUserByName(String username) {
		
		  this.userRepository.deleteById(this.userRepository.findByUsername(username).getId());
		
	}

	@Override
	public void deleteUserById(Long userId) {
		 this.userRepository.deleteById(userId);
		
	}

	@Override
	public User getUser(Long userId) {
		
		return this.userRepository.getById(userId);
	}

}
