package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.daoimpl.AdminDaoImpl;
import com.payroll.exception.EmployeeDelException;
import com.payroll.model.Admin;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mail=request.getParameter("email");
		String password=request.getParameter("pass");
		Admin admin=new Admin(mail,password);
		System.out.println(admin);
		AdminDaoImpl adminDaoImpl=new AdminDaoImpl();
		boolean adminFlag=adminDaoImpl.validateAdmin(admin);
		try {
			if(adminFlag){
				
				
				PrintWriter out =response.getWriter();
				
				out.println("<script type=\"text/javascript\">");
    			out.println("alert('Login Successfully');");
    			out.println("location='adminControl.jsp';");
    			out.println("</script>");
			}
			else {
				throw new EmployeeDelException();
				
			}	
			}
		catch(EmployeeDelException e) {
			HttpSession  session=request.getSession();
			session.setAttribute("invalid", e.getMessage1());
			response.sendRedirect("index.jsp");
		}
		 
			
}}
