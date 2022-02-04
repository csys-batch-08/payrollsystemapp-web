package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.daoimpl.DepartmentsDaoImpl;
import com.payroll.daoimpl.EmployeeDaoImpl;
import com.payroll.daoimpl.GradeDaoImpl;
import com.payroll.daoimpl.LeaveDaoImpl;
import com.payroll.daoimpl.SalaryCalculateDaoImpl;
import com.payroll.exception.SalaryInvalidException;
import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

@WebServlet("/salaryInsert")
public class SalaryAddController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		int empID = Integer.parseInt(request.getParameter("empId"));
		String gradeName = request.getParameter("gName");
		String deptName = request.getParameter("dName");
		String selectTax = request.getParameter("tax");
		String selectBonus = request.getParameter("bonus");
		

		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		Employee emp = empDao.findEmployee(empID);

		

		DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
		
		Departments depart = departDao.findDepartment(deptName);
		
		
		GradeDaoImpl gradeDao = new GradeDaoImpl();
		Grade grade = gradeDao.findGrade(gradeName, depart.getDeptId());
		
		LeaveDaoImpl leaveDao = new LeaveDaoImpl();
		int leaveDays = leaveDao.leaveDays(empID);
		long grossSalary = gradeDao.grossSalary(gradeName,depart.getDeptId());
		long perDaySalary = gradeDao.perDaySalary(gradeName,depart.getDeptId());
		long bonus = gradeDao.bonus(gradeName,depart.getDeptId());
		long pt = gradeDao.professionalTax(gradeName,depart.getDeptId());
		SalaryCalculateDaoImpl salaryCal = new SalaryCalculateDaoImpl();

		Date salaryDt = salaryCal.salaryNxtMonth(empID);
		String status = empDao.employStatus(empID);

		Date todayDate = empDao.todayDate();
		try {
			
		if(salaryDt==null) {
			salaryDt=todayDate;
		}
		if (todayDate.compareTo(salaryDt) == 0)  {
			try {
				
			
			if (status.equals("active")) {
				if (selectTax.equals("yes")) {
					if (selectBonus.equals("yes")) {
						long salaryBonus = (((grossSalary + bonus) - (leaveDays * perDaySalary)) - pt);
						boolean result = salaryCal.insertSalary(emp, grade, depart, leaveDays, grossSalary,
								salaryBonus);
						try {
							if (result) {
								PrintWriter out = response.getWriter();
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Salary Added Successfully');");
								out.println("location='AdminControl.jsp';");
								out.println("</script>");
							} else {
								throw new SalaryInvalidException();
							}
						} catch (SalaryInvalidException e) {
							HttpSession session = request.getSession();
							session.setAttribute("salaryInvalid", e.getMessage());
							response.sendRedirect("SalaryAdd.jsp");

						}
					} else {
						long salary = (((grossSalary) - (leaveDays * perDaySalary)) - pt);
						boolean result = salaryCal.insertSalary(emp, grade, depart, leaveDays, grossSalary, salary);
						try {
							if (result ) {
								PrintWriter out = response.getWriter();
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Salary Added Successfully');");
								out.println("location='adminControl.jsp';");
								out.println("</script>");
							} else {
								throw new SalaryInvalidException();
							}
						} catch (SalaryInvalidException e) {
							HttpSession session = request.getSession();
							session.setAttribute("salaryInvalid", e.getMessage());
							response.sendRedirect("salaryAdd.jsp");
						}
					}

				} else {
					if (selectBonus.equals("yes")) {
						long salaryBonus = (((grossSalary + bonus) - (leaveDays * perDaySalary)));

						boolean result = salaryCal.insertSalary(emp, grade, depart, leaveDays, grossSalary,
								salaryBonus);
						try {

							if (result ) {
								PrintWriter out = response.getWriter();
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Salary Added Successfully');");
								out.println("location='adminControl.jsp';");
								out.println("</script>");
							} else {
								throw new SalaryInvalidException();

							}
						} catch (SalaryInvalidException e) {
							HttpSession session = request.getSession();
							session.setAttribute("salaryInvalid", e.getMessage());
							response.sendRedirect("salaryAdd.jsp");
						}
					} else {
						long salary = (((grossSalary) - (leaveDays * perDaySalary)));

						boolean result = salaryCal.insertSalary(emp, grade, depart, leaveDays, grossSalary, salary);
						try {

							if (result ) {
								PrintWriter out = response.getWriter();
								out.println("<script type=\"text/javascript\">");
								out.println("alert('Salary Added Successfully');");
								out.println("location='adminControl.jsp';");
								out.println("</script>");

							}

							else {
								throw new SalaryInvalidException();
							}
						} catch (SalaryInvalidException e) {
							HttpSession session = request.getSession();
							session.setAttribute("salaryEntry", e.getMessage());
							response.sendRedirect("salaryAdd.jsp");
						}

					}

				}

			}
			else {
				throw new SalaryInvalidException();
			}}
			catch(SalaryInvalidException s) {
				HttpSession session = request.getSession();
				session.setAttribute("statusSal", s.statusInactiveEmp());
				response.sendRedirect("salaryAdd.jsp");
			}

		} 
		else {
			throw new SalaryInvalidException();
		}}
		catch(SalaryInvalidException e) {
			HttpSession session=request.getSession();
			session.setAttribute("DateSal", e.getSalMessage());
			response.sendRedirect("salaryAdd.jsp");
		}

	}

}
