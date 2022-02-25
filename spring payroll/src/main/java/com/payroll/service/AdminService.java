package com.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.payroll.daoimpl.AdminDaoImpl;
import com.payroll.model.Admin;


@Service
@ComponentScan("com")
public class AdminService {
	
	@Autowired
	Admin admin;
	
	@Autowired
	AdminDaoImpl adminDaoImpl;
	
	public  boolean validate(String email,String password) {
		 
		admin.setEmailId(email);
		admin.setPassword(password);
		return adminDaoImpl.validateAdmin(admin);
		
	}

}
