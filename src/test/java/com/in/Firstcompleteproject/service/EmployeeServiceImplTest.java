package com.in.Firstcompleteproject.service;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

@RunWith(MockitoJUnitRunner.Silent.class)
public class EmployeeServiceImplTest {
	
	@Mock
	EmployeeRepository employeerepository;
	
	@InjectMocks
	EmployeeServiceImpl employeeserviceimpl;
	
	
	CreateDto createdto;
	Employee employee;
	loginDto logindto ;
	
	@Before
	public void setup() {
		employee = new Employee();
		employee.setEmail("tukari@gmail.com");
		employee.setFirstName("ashish");
		employee.setLastName("kumar");
		employee.setPassword("Ashish@123");
		employee.setPhoneNo(1234567891);
		employee.setId(6);
		
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
		Mockito.when(employeerepository.save(Mockito.any())).thenReturn(employee);
		Employee e = employeeserviceimpl.creatRegistration(createdto);
		assertNotNull(e);
		assertEquals(e.getFirstName(), "ashish");
	}
	
	@Test
	public void LoginTest() {
		Mockito.when(employeerepository.findByemail(Mockito.any())).thenReturn(employee);
		Employee e  = employeeserviceimpl.login(logindto);
		 assertNotNull(e);
		assertEquals(e.getEmail(), "tukari@gmail.com");
			
		
	}

}
