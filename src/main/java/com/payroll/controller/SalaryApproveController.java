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

import com.payroll.daoimpl.EmployeeDaoImpl;
import com.payroll.exception.SalaryInvalidException;
import com.payroll.model.Employee;

@WebServlet("/ASE")
public class SalaryApproveController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int empId=Integer.parseInt(request.getParameter("eId"));
		EmployeeDaoImpl employDao=new EmployeeDaoImpl();
		Employee employ=employDao.findEmployee(empId);
		try {
			
		
		if(employ==null) {
			throw new SalaryInvalidException();
			
		}else {
			
		
		List<Employee> employSalApprove=new ArrayList();
		employSalApprove.add(employ);
		request.setAttribute("salEmpApprove", employSalApprove);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("salaryApprove.jsp");
		requestDispatcher.forward(request, response);
	}}
		catch(SalaryInvalidException invalidException) {
			HttpSession session = request.getSession();
			session.setAttribute("notFoundEmp", invalidException.employInvalid());
			response.sendRedirect("salaryAdd.jsp");
			}
		}


}
