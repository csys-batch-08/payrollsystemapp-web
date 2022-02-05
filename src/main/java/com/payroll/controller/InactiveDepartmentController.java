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
import com.payroll.model.Departments;

@WebServlet("/ShowInactiveDepart")
public class InactiveDepartmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentsDaoImpl departDao=new DepartmentsDaoImpl();
		List<Departments> departList=departDao.showInactiveDepartments();
		request.setAttribute("inactiveDeptList", departList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("departmentInactive.jsp");
		dispatcher.forward(request, response);
		
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
