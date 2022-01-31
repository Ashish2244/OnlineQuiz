package com.quiz.exception;

public class UserFoundException extends Exception {
	public UserFoundException() {
		super("User with this username already exits. Please Try with another !!");
	}
	public UserFoundException(String msg) {
		super(msg);
		
	}
	

}
