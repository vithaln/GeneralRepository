package com.vithal.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vithal.code.entity.Department;
import com.vithal.code.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	// create department

	@PostMapping("/")
	public ResponseEntity<Department> createDeparts(@RequestBody Department department) {

		Department createDepartments = departmentService.createDepartments(department);

		return new ResponseEntity<Department>(createDepartments, HttpStatus.CREATED);
	}

	// get all deprts
	@GetMapping("/")
	public ResponseEntity<List<Department>> getAlldeprts() {

		List<Department> alldepartments = departmentService.getAlldepartments();

		return new ResponseEntity<List<Department>>(alldepartments, HttpStatus.OK);
	}

	// get single deprts
	@GetMapping("/{did}")
	public ResponseEntity<Department> getSingleDeprts(@PathVariable String did) {
		Department singleDepartment = departmentService.getSingleDepartment(did);

		return new ResponseEntity<Department>(singleDepartment, HttpStatus.OK);
	}

	// delete deprts

	// get single deprts
	@DeleteMapping("/{did}")
	public ResponseEntity<String> deltedeprts(@PathVariable String did) {
		departmentService.deleteDepartment(did);
		return new ResponseEntity<String>("DEPARTMENT HAS BEEN DELTED SCCESFULL!!", HttpStatus.OK);
	}

	@PutMapping("/{did}")
	public ResponseEntity<Department> updateDeprts(@RequestBody Department department, @PathVariable String did) {

		Department updatedepartmenst = departmentService.updatedepartmenst(department, did);
		return new ResponseEntity<Department>(updatedepartmenst, HttpStatus.OK);
	}

	//find deprts by UId
	// get single deprts
		@GetMapping("user/{uId}")
		public ResponseEntity<List<Department>> getSingleDeprtsByUserId(@PathVariable String uId) {
			List<Department> deprtsByuserId = departmentService.getDeprtsByuserId(uId);

		//	return new ResponseEntity<Department>(deprtsByuserId, HttpStatus.OK);
			return ResponseEntity.ok(deprtsByuserId);
		}

}
