package com.vithal.code.exceptions;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super("USER NOT FOUND!");
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
}
