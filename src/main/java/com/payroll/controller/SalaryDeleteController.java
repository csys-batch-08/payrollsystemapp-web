package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.dao.SalaryCalculateDaoImpl;

/**
 * Servlet implementation class SalaryDeleteController
 */
@WebServlet("/salDel")
public class SalaryDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int transId=Integer.parseInt(request.getParameter("salId"));
		SalaryCalculateDaoImpl calculateDaoImpl=new SalaryCalculateDaoImpl();
		int i=calculateDaoImpl.deleteSalary(transId);
		if(i>0) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Salary Deleted Successfully');");
			out.println("location='adminControl.jsp';");
			out.println("</script>");
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Salary Not Deleted Successfully');");
			out.println("location='adminControl.jsp';");
			out.println("</script>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
