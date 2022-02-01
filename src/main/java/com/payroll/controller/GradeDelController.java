package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.dao.GradeDaoImpl;
@WebServlet("/GradeDel")
public class GradeDelController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		 GradeDaoImpl gradeDao=new GradeDaoImpl();
		int gradeId=Integer.parseInt(request.getParameter("gradeId"));
		gradeDao.deleteGrade(gradeId);
		PrintWriter out =response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Grade Deleted Successfully');");
		out.println("location='adminControl.jsp';");
		out.println("</script>");
		}

}
