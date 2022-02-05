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

import com.payroll.daoimpl.DepartmentsDaoImpl;
import com.payroll.exception.DepartmentException;
import com.payroll.model.Departments;

@WebServlet("/departmentSearch")
public class DepartmentSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("deptName");
		DepartmentsDaoImpl departmentDao = new DepartmentsDaoImpl();
		List<Departments> departmentList = departmentDao.searchDepartment(name);
		try {
			if(departmentList.isEmpty()) {
				throw new DepartmentException();
			}
			else {
				
			
		
		
		request.setAttribute("searchDept", departmentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("departmentSearch.jsp");
		dispatcher.forward(request, response);
		}}
		catch(DepartmentException departmentException) {
			
			HttpSession session = request.getSession();
			session.setAttribute("departSearchNtFound", departmentException.searchdepartfound());
			response.sendRedirect("departmentSearch.jsp");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
