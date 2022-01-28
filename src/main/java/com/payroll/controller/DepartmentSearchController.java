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

import com.payroll.dao.DepartmentsDaoImpl;
import com.payroll.model.Departments;

/**
 * Servlet implementation class DepartmentSearchController
 */
@WebServlet("/departmentSearch")
public class DepartmentSearchController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("deptName");
		DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
		List<Departments> departmentList=departmentDao.searchDepartment(name);
		HttpSession session=request.getSession();
		session.setAttribute("searchDept", departmentList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("departmentSearch.jsp");
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
