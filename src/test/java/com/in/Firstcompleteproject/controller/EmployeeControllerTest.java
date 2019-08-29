package com.in.Firstcompleteproject.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.entity.Employee;
import com.in.Firstcompleteproject.repository.EmployeeRepository;
import com.in.Firstcompleteproject.response.ApiResponse;
import com.in.Firstcompleteproject.service.EmployeeServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeControllerTest {
	
	
	@Mock
	EmployeeServiceImpl employeeserviceimpl;
	
	@InjectMocks
	EmployeeController employeecontroller;
	
	

    CreateDto createdto;
	Employee employee;
	loginDto logindto ;
	ApiResponse apiResponse;
	
	@Before
	public void setup() {
		apiResponse = new ApiResponse(200, null, apiResponse);
//		employee = new Employee();
//		employee.setEmail("tukari@gmail.com");
//		employee.setFirstName("ashish");
//		employee.setLastName("kumar");
//		employee.setPassword("Ashish@123");
//		employee.setPhoneNo(1234567891);
//		employee.setId(6);
		
		createdto = new CreateDto();
		createdto.setEmail("tukari@gmail.com");
		createdto.setFirstName("ashish");
		createdto.setLastName("kumar");
		createdto.setPassword("Ashish@123");
		createdto.setPhoneNo(1234567891);
		createdto.setId(6);
		
		logindto = new loginDto();
		logindto.setEmail("tukari@gmail.com");
		logindto.setPassword("Ashish@123");
	}
	
	@Test
	public void creatRegistrationTest() {
		Mockito.when(employeeserviceimpl.creatRegistration(Mockito.any())).thenReturn(apiResponse);
		ApiResponse apiResponse =  employeecontroller.CreateRegistration(createdto);
		assertEquals(200, apiResponse.getStatus());	
	}
	
	@Test
	public void LoginTest() {
		Mockito.when(employeeserviceimpl.login(Mockito.any())).thenReturn(apiResponse);
		ApiResponse apiResponse = employeeserviceimpl.login(logindto);
		assertEquals(200, apiResponse.getStatus());	
		
	}

}
