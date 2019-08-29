package com.in.Firstcompleteproject.service;

import java.util.List;
import java.util.Optional;

import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.employeeDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.entity.Employee;
import com.in.Firstcompleteproject.entity.employeeDetail;
import com.in.Firstcompleteproject.repository.EmployeeRepository;
import com.in.Firstcompleteproject.response.ApiResponse;



public interface EmployeeServic {
	
	
	
	
	
	public Employee  creatRegistration(CreateDto createdto);
	public Employee  login(loginDto logindto);
	
	public employeeDetail saveEmployee(employeeDto empdto);
	public List<employeeDetail> getallEmployee();
	public Optional<employeeDetail> getEmployeebyId(int id);
	public employeeDetail updateEmployee(employeeDto employedto);
	public void  deleteEmployee(int id);
	
	
	

}
