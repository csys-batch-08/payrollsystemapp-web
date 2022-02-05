package com.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.daoimpl.GradeDaoImpl;
import com.payroll.model.Grade;


@WebServlet("/GradeShow")
public class GradeShowController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GradeDaoImpl gradeDao=new GradeDaoImpl();
		List<Grade> gradeList=gradeDao.showGrade();
		request.setAttribute("grdList", gradeList);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("gradeShow.jsp");
		requestDispatcher.forward(request, response);
		
	}



}
