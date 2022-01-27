package com.payroll.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class EmployeeEditController
 */
@WebServlet("/UpdEmp")
public class EmployeeEditController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int empId = Integer.parseInt(request.getParameter("empId"));
		EmployeeDaoImpl employDao = new EmployeeDaoImpl();
		Employee employ = employDao.findEmployee(empId);
		List<Employee> employeeList=new ArrayList<Employee>();
		employeeList.add(employ);
		HttpSession session=request.getSession();
		session.setAttribute("editEmployee", employeeList);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("EmployUpd.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}