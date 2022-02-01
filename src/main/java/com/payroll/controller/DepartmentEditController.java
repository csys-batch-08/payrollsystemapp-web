package com.payroll.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
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

@WebServlet("/EditDept")
public class DepartmentEditController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
		int deptId=Integer.parseInt(request.getParameter("departId"));
		HttpSession session=request.getSession();
		session.setAttribute("editDeptId", deptId);
		DepartmentsDaoImpl departDao=new DepartmentsDaoImpl();
		Departments depart=departDao.findDepartment(deptId);
		List<Departments> department=new ArrayList<Departments>();
		department.add(depart);
		session.setAttribute("department", department);
		RequestDispatcher dispatcher=request.getRequestDispatcher("departmentUpdate.jsp");
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
