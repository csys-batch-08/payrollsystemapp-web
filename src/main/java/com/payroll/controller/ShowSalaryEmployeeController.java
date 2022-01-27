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

import com.payroll.dao.LeaveDaoImpl;
import com.payroll.dao.SalaryCalculateDaoImpl;
import com.payroll.model.EmpSalary;

/**
 * Servlet implementation class ShowSalaryEmployeeController
 */
@WebServlet("/ShowSalaryEmpl")
public class ShowSalaryEmployeeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
		List<EmpSalary> SalaryEmploy=salaryCal.showEmployee();
		HttpSession session=request.getSession();
		session.setAttribute("salaryShowList", SalaryEmploy);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ShowSalaryEmploy.jsp");
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