package com.quiz.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
	//public Long deleteByUsername(String username);
	
	
}
