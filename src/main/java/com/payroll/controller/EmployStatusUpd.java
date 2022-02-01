package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.dao.EmployeeDaoImpl;
import com.payroll.model.Employee;
@WebServlet("/EmpStatus")
public class EmployStatusUpd extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("statusId"));
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		Employee employ=employeeDao.findEmployee(empId);
		int i=employeeDao.updateStatusActive(employ);
		if(i!=0) {
			
			PrintWriter out =response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Employee Status Updated ');");
			out.println("location='employeeShow';");
			out.println("</script>");
		}
		
		
	}

}
