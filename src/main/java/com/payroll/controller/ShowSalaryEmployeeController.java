package com.payroll.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.daoimpl.SalaryCalculateDaoImpl;
import com.payroll.model.EmpSalary;


@WebServlet("/ShowSalaryEmpl")
public class ShowSalaryEmployeeController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
		List<EmpSalary> salaryEmploy=salaryCal.showEmployee();
		request.setAttribute("salaryShowList", salaryEmploy);
		RequestDispatcher dispatcher=request.getRequestDispatcher("salaryShow.jsp");
		dispatcher.forward(request, response);
	}

	

}
