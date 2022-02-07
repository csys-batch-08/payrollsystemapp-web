package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.payroll.daoimpl.DepartmentsDaoImpl;
import com.payroll.daoimpl.GradeDaoImpl;
import com.payroll.model.Grade;

@WebServlet("/GrdNameValidate")
public class gradeNameValidateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String grdName=request.getParameter("grdName");
		Grade grade=new Grade();
		grade.setGradeName(grdName);
		PrintWriter write = null;
		try {
			write = response.getWriter();
			if (grdName.length() > 0) {
				GradeDaoImpl daoImpl=new GradeDaoImpl();
				boolean condition = daoImpl.validateGradeName(grade);
				
				if (condition) {
					write.print("This Grade Name Not Found");
				} else {
					
					write.print(" Available");
				}}
		} catch (IOException e) {

			e.printStackTrace();
		}
	
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			doGet(request, response);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
	}

}
