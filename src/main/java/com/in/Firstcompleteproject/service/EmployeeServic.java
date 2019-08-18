package com.in.Firstcompleteproject.service;

import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.response.ApiResponse;

public interface EmployeeServic {
	
	
	
	public ApiResponse  creatRegistration(CreateDto createdto);
	public ApiResponse  login(loginDto logindto);

}
