package com.payroll.controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class GradeEditController
 */
@WebServlet("/GradeEdit")
public class GradeEditController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gradeId=Integer.parseInt(request.getParameter("gradeId"));
		HttpSession session=request.getSession();
		session.setAttribute("gradeId", gradeId);
		GradeDaoImpl gradeDao=new GradeDaoImpl();
		Grade gradeList=gradeDao.findGrade(gradeId);
		List<Grade> grade=new ArrayList<Grade>();
		
		grade.add(gradeList);
		session.setAttribute("Grade", grade);
		RequestDispatcher dispatcher=request.getRequestDispatcher("gradeUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
