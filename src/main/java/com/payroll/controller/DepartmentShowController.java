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

@WebServlet("/showDept")
public class DepartmentShowController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentsDaoImpl departDao=new DepartmentsDaoImpl();
		List<Departments> departList=departDao.showDepartments();
		HttpSession session=request.getSession();
		session.setAttribute("deptList", departList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("departmentShow.jsp");
		dispatcher.forward(request, response);
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
