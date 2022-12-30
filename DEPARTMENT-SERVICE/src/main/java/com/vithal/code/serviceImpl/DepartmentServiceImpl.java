package com.vithal.code.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vithal.code.entity.Department;
import com.vithal.code.exceptions.DepartmentNotFOund;
import com.vithal.code.repository.DepartmenRepo;
import com.vithal.code.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmenRepo repo;

	@Override
	public Department createDepartments(Department department) {
	
		String did = UUID.randomUUID().toString();
		department.setdId(did);
		Department departmentz = repo.save(department);
		return departmentz;
	}

	@Override
	public List<Department> getAlldepartments() {
		List<Department> departments = repo.findAll();
		return departments;
	}

	@Override
	public Department getSingleDepartment(String dId) {
		Department department = repo.findById(dId).orElseThrow(()-> new DepartmentNotFOund("DEPARTMENT NOT FOUND BY USING THIS ID: "+dId));
		return department;
	}

	@Override
	public Department updatedepartmenst(Department department, String dId) {
		Department depart = repo.findById(dId).orElseThrow(()-> new DepartmentNotFOund("DEPARTMENT NOT FOUND BY USING THIS ID: "+dId));
		
		depart.setdName(department.getdName());
		depart.setdType(department.getdType());
		depart.setdLocation(department.getdLocation());
		
		Department updatedDepartments = repo.save(depart);
		return updatedDepartments;
	}

	@Override
	public void deleteDepartment(String dId) {
		 repo.findById(dId).orElseThrow(()-> new DepartmentNotFOund("DEPARTMENT NOT FOUND to DELETE BY USING THIS ID: "+dId));
repo.deleteById(dId);
		
	}

	@Override
	public List<Department> getDeprtsByuserId(String uId) {
	List<Department> findByUId = repo.findByuId(uId);
		return findByUId;
	}
	
	
}
