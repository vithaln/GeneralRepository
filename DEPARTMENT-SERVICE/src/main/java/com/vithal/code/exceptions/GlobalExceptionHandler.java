package com.vithal.code.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler {

	@ExceptionHandler(DepartmentNotFOund.class)
	public ResponseEntity<Map<String,Object>> departmentNotfoundhandler(DepartmentNotFOund ex){
		
		Map<String, Object> mp=new HashMap<>();
		mp.put("MESSAGE", ex.getMessage());
		mp.put("success", false);
		mp.put("status", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Map<String,Object>>(mp,HttpStatus.NOT_FOUND);
	}
	
}
