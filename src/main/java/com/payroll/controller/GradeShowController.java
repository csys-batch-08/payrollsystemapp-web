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

import com.payroll.dao.GradeDaoImpl;
import com.payroll.model.Grade;

/**
 * Servlet implementation class GradeShowController
 */
@WebServlet("/GradeShow")
public class GradeShowController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GradeDaoImpl gradeDao=new GradeDaoImpl();
		List<Grade> gradeList=gradeDao.showGrade();
		HttpSession session=request.getSession();
		session.setAttribute("grdList", gradeList);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("gradeShow.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
