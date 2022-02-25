package com.payroll.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.payroll.dao.EmployeeDao;
import com.payroll.entity.EmployeeEntity;

public class EmployeeService {

	@Autowired
	EmployeeDao employRepo;

public List<EmployeeEntity> showEmploy() {
		
		return employRepo.findAll();
		
		
	}
}
