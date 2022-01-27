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
 * Servlet implementation class ShowEmployee
 */
@WebServlet("/ShowEmployee")
public class ShowEmployeeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDaoImpl employeeDao=new  EmployeeDaoImpl();
		List<Employee> employeeList=employeeDao.showEmployee();
		HttpSession session=request.getSession();
		session.setAttribute("empList", employeeList);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmpShow.jsp");
		requestDispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}