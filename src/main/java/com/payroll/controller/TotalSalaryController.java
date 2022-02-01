package com.payroll.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.SalaryCalculateDaoImpl;
import com.payroll.daoimpl.SalaryCalculateDao;

@WebServlet("/totalSal")
public class TotalSalaryController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SalaryCalculateDaoImpl salaryDao = new SalaryCalculateDaoImpl();
		int activeEmp = salaryDao.activeEmployee();
		HttpSession session = request.getSession();
		session.setAttribute("actEmp", activeEmp);
		int inActiveEmp = salaryDao.inActiveEmployee();
		int salCount = salaryDao.salaryEmpCount();
		session.setAttribute("inactEmp", inActiveEmp);
		session.setAttribute("salCount", salCount);
		RequestDispatcher dispatcher = request.getRequestDispatcher("salaryEmployCount.jsp");
		dispatcher.forward(request, response);

	}

}
