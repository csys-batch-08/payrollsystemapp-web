package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.EmployeeDaoImpl;
import com.payroll.exception.EmployeeDelException;
import com.payroll.model.Employee;

/**
 * Servlet implementation class EmployeeDelController
 */
@WebServlet("/empDel")
public class EmployeeDelController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empId=Integer.parseInt(request.getParameter("empId"));
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		Employee employ=employeeDao.findEmployee(empId);
		int i=employeeDao.updateEmpStatus(employ);
		try {
			
		
		if(i>0) {
			
			PrintWriter out =response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Employee Status Updated To In-active');");
			out.println("location='adminControl.jsp';");
			out.println("</script>");
			
		}
		else {
			throw new EmployeeDelException();
		}}
		catch(EmployeeDelException e) 
		{
			HttpSession session=request.getSession();
			session.setAttribute("employDel", e.EmployeeDel());
			response.sendRedirect("employeeShow.jsp");
		}
	
	}

}
