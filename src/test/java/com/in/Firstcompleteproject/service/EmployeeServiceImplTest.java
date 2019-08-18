package com.in.Firstcompleteproject.service;


import static org.junit.Assert.assertEquals;

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
	//loginDto logindto ;
	
	public void creatRegistrationTest() {
		employee = new Employee();
		employee.setEmail("vk@gmail.com");
		employee.setFirstName("vikash");
		employee.setLastName("kumar");
		employee.setPassword("vk@123");
		employee.setPhoneNo(123456789);
		employee.setId(1);
		
		createdto = new CreateDto();
		createdto.setEmail("vk@gmail.com");
		createdto.setFirstName("vikash");
		createdto.setLastName("kumar");
		createdto.setPassword("vk@123");
		createdto.setPhoneNo(123456789);
		createdto.setId(1);
		
		Mockito.when(employeerepository.save(Mockito.any())).thenReturn(employee);
		ApiResponse ApiResponse = employeeserviceimpl.creatRegistration(createdto);
		assertEquals(200, ApiResponse.getStatus());
		
		
		
		
	}

}
