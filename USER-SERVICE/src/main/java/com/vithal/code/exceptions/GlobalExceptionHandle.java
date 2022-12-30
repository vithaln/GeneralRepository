package com.vithal.code.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Map<String,Object>> userNotfoundxceptionHandler(UserNotFoundException ex){
		
		Map<String,Object> map=new HashMap<>();
		map.put("message", ex.getMessage());
		map.put("status", HttpStatus.NOT_FOUND);
		map.put("succes", false);
		
		return new ResponseEntity<Map<String, Object>>(map,HttpStatus.NOT_FOUND);
	}
}
