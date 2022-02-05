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
import com.payroll.exception.EmployeeDelException;
import com.payroll.model.Employee;

@WebServlet("/searchEmployee")
public class searchEmployeeController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("empName");
		EmployeeDaoImpl employDao=new EmployeeDaoImpl();
		
		List<Employee> employeeList=employDao.searchEmployee(name);
		try {
			
		
		if(employeeList.isEmpty()) {
			
			throw new EmployeeDelException();
		}
		else {
			request.setAttribute("searchEmp", employeeList);
			RequestDispatcher dispatcher=request.getRequestDispatcher("employeeSearch.jsp");
			dispatcher.forward(request, response);
		}
		}
		catch(EmployeeDelException delException) {
			HttpSession session = request.getSession();
			session.setAttribute("searchNtFound", delException.searchEmpNotFnd());
			response.sendRedirect("employeeSearch.jsp");
		}
		
	}
	

	


}
