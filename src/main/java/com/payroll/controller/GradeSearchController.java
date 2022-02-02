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

@WebServlet("/GradeSearchController")
public class GradeSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("gradeName");
		GradeDaoImpl gradeDao = new GradeDaoImpl();
		List<Grade> listGrade = gradeDao.searchGrade(name);
		HttpSession session = request.getSession();
		session.setAttribute("searchListGrade", listGrade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("gradeSearch.jsp");
		dispatcher.forward(request, response);

	}

}
