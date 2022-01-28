package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.DepartmentsDaoImpl;
import com.payroll.dao.GradeDaoImpl;
import com.payroll.exception.DepartmentException;
import com.payroll.model.Departments;
import com.payroll.model.Grade;

@WebServlet("/deptAdd")
public class DepartmentAddController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptName = request.getParameter("dptname");
		DepartmentsDaoImpl departDao = new DepartmentsDaoImpl();
		Departments department = new Departments(deptName);
		Departments depart = departDao.findDepartment(deptName);
		try {
			if (depart == null) {

				int i = departDao.insertDep(department);
				try {
					if (i > 0) {
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Department Added Successfully');");
						out.println("location='adminControl.jsp';");
						out.println("</script>");
					} else {
						throw new DepartmentException();
					}
				}

				catch (DepartmentException e) {
					HttpSession session = request.getSession();
					session.setAttribute("deptAdd", e.getMessage());
					response.sendRedirect("departmentAdd.jsp");
				}
			} else {
				throw new DepartmentException();
			}
		} catch (DepartmentException e) {
			HttpSession session = request.getSession();
			session.setAttribute("departAlready", e.getDeptInvalid());
			response.sendRedirect("DepartmentAdd.jsp");

		}

	}
}
