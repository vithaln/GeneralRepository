package com.vithal.code.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.Department;

public interface DepartmenRepo extends JpaRepository<Department, String> {

	//custom method
	List<Department> findByuId(String uId);
}
