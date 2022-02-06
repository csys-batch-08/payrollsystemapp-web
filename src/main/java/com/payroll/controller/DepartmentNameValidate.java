package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.daoimpl.DepartmentsDaoImpl;
import com.payroll.model.Departments;

@WebServlet("/deptNameValidate")
public class DepartmentNameValidate extends HttpServlet {
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		String departName=request.getParameter("deptName");
		Departments department=new Departments();
		department.setDeptName(departName);
		PrintWriter write = null;
		
		try {
			write = response.getWriter();
			if (departName.length() > 0) {
				DepartmentsDaoImpl daoImpl=new DepartmentsDaoImpl();
				boolean condition = daoImpl.validateDepartName(department);
				
				if (condition) {
					write.print("This Department Name Not Found");
				} else {
					write.print(" Available");
				}}
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
		
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
