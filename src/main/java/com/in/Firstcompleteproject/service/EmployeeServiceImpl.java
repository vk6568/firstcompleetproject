package com.in.Firstcompleteproject.service;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.Firstcompleteproject.controller.EmployeeController;
import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.entity.Employee;
import com.in.Firstcompleteproject.repository.EmployeeRepository;
import com.in.Firstcompleteproject.response.ApiResponse;


@Service
public class EmployeeServiceImpl implements EmployeeServic {
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employee ;

	@Override
	public ApiResponse creatRegistration(CreateDto createdto) {
		// TODO Auto-generated method stub
		Employee empl = new Employee();
		BeanUtils.copyProperties(createdto, empl);
		employee.save(empl);
		logger.info("sevice creatRegistration");
		return new ApiResponse(200, " Registration successfull", empl);
	}

	@Override
	public ApiResponse login(loginDto logindto) {
		// TODO Auto-generated method stub
		Employee empl =  employee.findByemail(logindto.getEmail());
		if(empl==null) {
			
			throw new RuntimeException("email not found");
		}
		if(!empl.getPassword().equals(logindto.getPassword())) {
			
			throw new RuntimeException("password not match");
		}
		logger.info("sevice login");
		return new ApiResponse(200,"login successfull " ,empl);
	}

	

}
