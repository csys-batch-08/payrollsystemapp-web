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

/**
 * Servlet implementation class DepartmentDelController
 */
@WebServlet("/departDel")
public class DepartmentDelController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int departId=Integer.parseInt(request.getParameter("deptId"));
		DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
		boolean flag=departmentDao.deleteDept(departId);
		try {
			
		
		if(flag) {
			
		
		PrintWriter out =response.getWriter();
		
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Department Deleted Successfully');");
		out.println("location='DepartShow.jsp';");
		out.println("</script>");
		}
		else {
			throw new DepartmentException();
		}}
		catch(DepartmentException d) {
			HttpSession session=request.getSession();
			session.setAttribute("depDelete", d.deptDelete());
			response.sendRedirect("DepartShow.jsp");
		}
		
	}

}
