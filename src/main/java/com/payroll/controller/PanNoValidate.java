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


@WebServlet("/panNoValidate")
public class PanNoValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String panNo=request.getParameter("panNo");
		Employee employ=new Employee();
		employ.setPanNo(panNo);
		PrintWriter write = null;
		try {
			write = response.getWriter();
		} catch (IOException e) {

			e.printStackTrace();
		}
		if (panNo.length() > 0) {
			EmployeeDaoImpl employeeDaoImpl=new EmployeeDaoImpl(); 
			boolean condition = employeeDaoImpl.validatePanNo(employ);
			
			if (!condition) {
				write.print("This PanNumber Already Available");
			} else {
				write.print("Not Available");
			}}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
