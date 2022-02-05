package com.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.daoimpl.EmployeeDaoImpl;
import com.payroll.model.Employee;


@WebServlet("/ShowEmployee")
public class ShowEmployeeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl employeeDao=new  EmployeeDaoImpl();
		List<Employee> employeeList=employeeDao.showEmployee();
		request.setAttribute("empList", employeeList);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("employeeShow.jsp");
		requestDispatcher.forward(request, response);
		
	}



}
