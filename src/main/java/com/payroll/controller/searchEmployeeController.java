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

import com.payroll.dao.EmployeeDaoImpl;
import com.payroll.model.Employee;

/**
 * Servlet implementation class searchEmployeeController
 */
@WebServlet("/searchEmployee")
public class searchEmployeeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("empName");
		EmployeeDaoImpl employDao=new EmployeeDaoImpl();

		List<Employee> employeeList=employDao.searchEmployee(name);
		HttpSession session=request.getSession();
		session.setAttribute("searchEmp", employeeList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("employeeSearch.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
