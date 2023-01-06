package com.vithal.code;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vithal.code.entity.Department;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface DepartemntServiceConfig {

	@GetMapping("/dept/{hotelId}")
	Department getDepartmentsBydepartlId(@PathVariable String hotelId);
	
}
