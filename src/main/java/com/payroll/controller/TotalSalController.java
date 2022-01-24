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

import com.payroll.dao.SalaryCalculateDaoImpl;

/**
 * Servlet implementation class TotalSalController
 */
@WebServlet("/totalAmount")
public class TotalSalController extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fromSal=sdf.parse(request.getParameter("salfromDt"));
			Date toSal=sdf.parse(request.getParameter("saltoDate"));
			SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
			int total=salaryCal.totalSal(fromSal, toSal);
			PrintWriter pw=response.getWriter();
			pw.print(total);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
