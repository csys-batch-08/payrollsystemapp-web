package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
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
import com.payroll.exception.DepartmentException;
import com.payroll.exception.EmployeeDelException;
import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;

@WebServlet("/empAdd")
public class EmployeeAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String name = request.getParameter("EmployeeName");
		Date dob = null;
		Date doj = null;
		try {
			dob = sdf.parse(request.getParameter("dob"));
			doj = sdf.parse(request.getParameter("doj"));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		long pincode = Long.parseLong(request.getParameter("pincode"));
		long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));
		String state = request.getParameter("state");
		String mailId = request.getParameter("mailId");
		String panNo = request.getParameter("panNo");
		String DeptName = request.getParameter("deptName");
		String grdName = request.getParameter("grdName");
		DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
		Departments depart = departDao.findDepartment(DeptName);
		GradeDaoImpl gradeDao = new GradeDaoImpl();
		Grade grade = gradeDao.findGrade(grdName, depart.getDeptId());
		Employee employ = new Employee(name, dob, doj, address, city, pincode, mobileNumber, state, mailId, panNo,
				depart, grade);
		EmployeeDaoImpl employDao = new EmployeeDaoImpl();

		try {

			if (grade != null) {

				boolean empResult = employDao.insertEmp(employ);

				if (empResult) {
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Employee Added Successfully');");
					out.println("location='adminControl.jsp';");
					out.println("</script>");
				} else {
					throw new EmployeeDelException();

				}

			} else {
				throw new DepartmentException();

			}
		} catch (DepartmentException d) {
			HttpSession session = request.getSession();
			session.setAttribute("gradeDept", d.gradeDept());
			response.sendRedirect("employeeAdd.jsp");

		} catch (EmployeeDelException e) {
			HttpSession session = request.getSession();
			session.setAttribute("employInvalid", e.getEmployAdd());
			response.sendRedirect("employeeAdd.jsp");

		}
	}

}
