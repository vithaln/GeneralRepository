package com.vithal.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vithal.code.entity.Department;

public interface DepartmenRepo extends JpaRepository<Department, String> {

}
