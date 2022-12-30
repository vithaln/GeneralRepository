package com.vithal.code.service;

import java.util.List;

import com.vithal.code.entity.Department;

public interface DepartmentService {

	//create departments
	
	Department createDepartments(Department department);
	
	//get all departments
	
	List<Department> getAlldepartments();
	
	//get single deprtments by department id
	
	Department getSingleDepartment(String dId);
	
	//update departments
	
	Department updatedepartmenst(Department department,String dId);
	
	
	//delete deprtmenst
	
	void deleteDepartment(String dId);
}
