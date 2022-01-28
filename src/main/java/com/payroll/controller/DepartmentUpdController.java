package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.DepartmentsDaoImpl;
import com.payroll.exception.DepartmentException;
import com.payroll.model.Departments;

/**
 * Servlet implementation class DepartmentUpdController
 */
@WebServlet("/deptUpd")
public class DepartmentUpdController extends HttpServlet {
    
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		DepartmentsDaoImpl department=new DepartmentsDaoImpl();
		String departName=request.getParameter("name");
		HttpSession session=request.getSession();
		int deptID=Integer.parseInt(session.getAttribute("editDeptId").toString());
		Departments deprt=department.findDepartment(deptID);
		deprt.setDeptName(departName);
		int i=department.updateDept(deprt);
		try {
			
		
		if(i>0) {
			
		
		PrintWriter out =response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Department Updated Successfully');");
		out.println("location='departmentShow.jsp';");
		out.println("</script>");
		}
		else {
			throw new DepartmentException();
		}}
		catch(DepartmentException d) {
			session.setAttribute("deptUpdData", d.deptNotUpdate());
			response.sendRedirect("departmentUpdate.jsp");
		}
		
	}

}
