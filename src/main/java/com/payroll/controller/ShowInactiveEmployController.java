package com.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.daoimpl.EmployeeDaoImpl;
import com.payroll.model.Employee;


@WebServlet("/ShowInactiveEmploy")
public class ShowInactiveEmployController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();

		List<Employee> employeeList=employeeDao.showInactiveEmployee();
		HttpSession session=request.getSession();
		session.setAttribute("showInActiveEmp", employeeList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("employeeShowInActive.jsp");
		dispatcher.forward(request, response);
	}

	

}
