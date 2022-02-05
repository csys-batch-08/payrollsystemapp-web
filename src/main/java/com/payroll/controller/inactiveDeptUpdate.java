package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.daoimpl.DepartmentsDaoImpl;
import com.payroll.daoimpl.EmployeeDaoImpl;
import com.payroll.model.Departments;
import com.payroll.model.Employee;

/**
 * Servlet implementation class inactiveDeptUpdate
 */
@WebServlet("/deptStatus")
public class inactiveDeptUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptId = Integer.parseInt(request.getParameter("statusId"));
		DepartmentsDaoImpl  departmentsDaoImpl=new DepartmentsDaoImpl();
		Departments department = departmentsDaoImpl.findDepartment(deptId);
		int i = departmentsDaoImpl.updateStatusActive(department);
		if (i != 0) {

			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Department Status Updated ');");
			out.println("location='adminControl.jsp';");
			out.println("</script>");
		}

	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
