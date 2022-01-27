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
import com.payroll.model.Departments;
import com.payroll.model.Employee;

/**
 * Servlet implementation class SalaryApproveController
 */
@WebServlet("/ASE")
public class SalaryApproveController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empId=Integer.parseInt(request.getParameter("eId"));
		EmployeeDaoImpl employDao=new EmployeeDaoImpl();
		Employee employ=employDao.findEmployee(empId);
		List<Employee> employSalApprove=new ArrayList<Employee>();
		employSalApprove.add(employ);
		HttpSession session=request.getSession();
		session.setAttribute("salEmpApprove", employSalApprove);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("SalaryApprove.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
