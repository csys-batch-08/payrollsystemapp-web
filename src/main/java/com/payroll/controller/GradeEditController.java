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

import com.payroll.daoimpl.GradeDaoImpl;
import com.payroll.model.Grade;

@WebServlet("/GradeEdit")
public class GradeEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int gradeId = Integer.parseInt(request.getParameter("gradeId"));
		HttpSession session = request.getSession();
		session.setAttribute("gradeId", gradeId);
		GradeDaoImpl gradeDao = new GradeDaoImpl();
		Grade gradeList = gradeDao.findGrade(gradeId);
		List<Grade> grade = new ArrayList<Grade>();

		grade.add(gradeList);
		session.setAttribute("Grade", grade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("gradeUpdate.jsp");
		dispatcher.forward(request, response);
	}

}
