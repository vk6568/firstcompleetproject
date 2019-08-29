package com.in.Firstcompleteproject.service;


import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.Firstcompleteproject.controller.EmployeeController;
import com.in.Firstcompleteproject.dto.CreateDto;
import com.in.Firstcompleteproject.dto.employeeDto;
import com.in.Firstcompleteproject.dto.loginDto;
import com.in.Firstcompleteproject.entity.Employee;
import com.in.Firstcompleteproject.entity.employeeDetail;
import com.in.Firstcompleteproject.repository.EmployeeDetailsRepository;
import com.in.Firstcompleteproject.repository.EmployeeRepository;
import com.in.Firstcompleteproject.response.ApiResponse;




@Service
public class EmployeeServiceImpl implements EmployeeServic {
	
	private static final org.jboss.logging.Logger logger = LoggerFactory.logger(EmployeeController.class);
	
	@Autowired
	private EmployeeRepository employeerepo ;
	
	@Autowired
	private EmployeeDetailsRepository empldetail;

	@Override
	public Employee creatRegistration(CreateDto createdto) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		
		BeanUtils.copyProperties(createdto,employee);
		
		logger.info("sevice creatRegistration");
		return employeerepo.save(employee);
	}

	@Override
	public Employee login(loginDto logindto) {
		// TODO Auto-generated method stub
		Employee empl =  employeerepo.findByemail(logindto.getEmail());
		if(empl==null) {
			
			throw new RuntimeException("email not found");
		}
		if(!empl.getPassword().equals(logindto.getPassword())) {
			
			throw new RuntimeException("password not match");
		}
		logger.info("sevice login");
		return empl;
	}

	@Override
	public employeeDetail saveEmployee(employeeDto empdto) {
		// TODO Auto-generated method stub
		
		employeeDetail emp = new employeeDetail();
		BeanUtils.copyProperties(empdto, emp);
		
	    return empldetail.save(emp);
	}

	@Override
	public List<employeeDetail> getallEmployee() {
		// TODO Auto-generated method stub
		
		 return empldetail.findAll();
	}

	@Override
	public Optional<employeeDetail> getEmployeebyId(int id) {
		// TODO Auto-generated method stub
		return empldetail.findById(id);
	}

	@Override
	public employeeDetail updateEmployee(employeeDto employedto) {
		// TODO Auto-generated method stub
		employeeDetail emps = new employeeDetail();
		BeanUtils.copyProperties(employedto, emps);
		return  empldetail.saveAndFlush(emps);
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		 empldetail.deleteById(id);
	}

	

}
