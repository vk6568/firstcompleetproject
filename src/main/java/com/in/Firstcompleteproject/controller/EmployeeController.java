package com.in.Firstcompleteproject.controller;


import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.core.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
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

import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.employeeDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.entity.Employee;
import com.in.Firstcompleteproject.entity.employeeDetail;
import com.in.Firstcompleteproject.response.ApiResponse;
import com.in.Firstcompleteproject.service.EmployeeServiceImpl;




@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(EmployeeController.class);
	
    @Autowired
	private EmployeeServiceImpl employeeimplservice;
	
	@PostMapping("/save")
	public ResponseEntity CreateRegistration(@RequestBody CreateDto createdto) {
		
		Employee employe=employeeimplservice.creatRegistration(createdto);
		   
		logger.info("registration");
		return  new ResponseEntity<String>("success registration",HttpStatus.OK);
			
	}
	@PostMapping("/login")
    public ResponseEntity login(@RequestBody loginDto logindto) {
		
		Employee employe=employeeimplservice.login(logindto);
		
		logger.info("login");
    	
		return  new ResponseEntity<String>("success login",HttpStatus.OK);
    	
    }
	
	@PostMapping("/empsave")
	public ResponseEntity Employeesave(@RequestBody employeeDto empdto) {
		
		employeeDetail empd = employeeimplservice.saveEmployee(empdto);
		
		return   new ResponseEntity<String>("successfull save",HttpStatus.OK);
		
	}
	
	@GetMapping("/getall")
	public ResponseEntity EmployeeAll() {
		
    	 List<employeeDetail> empde= employeeimplservice.getallEmployee();
		 return new ResponseEntity<List<employeeDetail>>(empde, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity GetByid(@PathVariable int id) {
		
		Optional<employeeDetail> empid= employeeimplservice.getEmployeebyId(id);
		
		return new ResponseEntity<Optional<employeeDetail>>(empid, HttpStatus.OK); 
			
	}
	@PutMapping("/update")
	public ResponseEntity updateemployee(@RequestBody employeeDto employedto) {
		
        employeeDetail empd = employeeimplservice.updateEmployee(employedto);
		
		return   new ResponseEntity<String>("successfull update",HttpStatus.OK);
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) {
		
         employeeimplservice.deleteEmployee(id);
		
		return new ResponseEntity<String>("delete successfull", HttpStatus.OK); 
		
	}
	
}
