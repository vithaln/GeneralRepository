package com.vithal.code.exceptions;

public class DepartmentNotFOund extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DepartmentNotFOund() {
		super("Department not found !!");
	}
	
	public DepartmentNotFOund(String msg) {
		super(msg);
	}
}
