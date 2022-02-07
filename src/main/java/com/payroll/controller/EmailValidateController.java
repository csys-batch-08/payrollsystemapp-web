package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.daoimpl.EmployeeDaoImpl;
import com.payroll.model.Employee;


@WebServlet("/emailValidate")
public class EmailValidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailId=request.getParameter("email");
		Employee employ=new Employee();
		employ.setMailId(emailId);
		PrintWriter write = null;
		try {
			write = response.getWriter();
			if (emailId.length() > 0) {
				EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl(); 
				boolean condition = employeeDaoImpl.validateEmail(employ);
				
				if (!condition) {
					write.print("This Email Already Available");
				} else {
					write.print("Not Available");
				}}
		
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}
