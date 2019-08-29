package com.in.Firstcompleteproject.controller;


import org.apache.logging.log4j.core.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.entity.Employee;
import com.in.Firstcompleteproject.response.ApiResponse;
import com.in.Firstcompleteproject.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(EmployeeController.class);
	
    @Autowired
	private EmployeeServiceImpl employeeimplservice;
	
	@PostMapping("/save")
	public ApiResponse CreateRegistration(@RequestBody CreateDto createdto) {
		   
		logger.info("registration");
		return  employeeimplservice.creatRegistration(createdto);
			
	}
	@PostMapping("/login")
    public ApiResponse login(@RequestBody loginDto logindto) {
		
		logger.info("login");
    	
		return employeeimplservice.login(logindto);
    	
    }
}
