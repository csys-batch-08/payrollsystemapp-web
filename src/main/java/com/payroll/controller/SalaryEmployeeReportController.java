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

import com.payroll.dao.EmployeeDaoImpl;
import com.payroll.dao.SalaryCalculateDaoImpl;
import com.payroll.model.EmpSalary;
import com.payroll.model.Employee;

@WebServlet("/SalaryReport")
public class SalaryEmployeeReportController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employId=Integer.parseInt(request.getParameter("eId"));
		EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
		Employee employ=employeeDao.findEmployee(employId);
		if(employ!=null)
		{
		SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
		EmpSalary salary=salaryCal.salaryDetail(employId);
		List<EmpSalary> empSalaryList=new ArrayList<EmpSalary>();
		empSalaryList.add(salary);
		HttpSession session=request.getSession();
		session.setAttribute("empSalList", empSalaryList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("salaryReport.jsp");
		dispatcher.forward(request, response);
		}
		
	}


}
