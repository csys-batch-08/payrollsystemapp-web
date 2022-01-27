package com.payroll.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.SalaryCalculateDaoImpl;

/**
 * Servlet implementation class TotalAmountController
 */
@WebServlet("/totalAmount")
public class TotalAmountController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
				String fromSal=request.getParameter("fromSal");
				String toSal=request.getParameter("toSal");
				Date fromDt=sdf.parse(fromSal);
				Date toDt=sdf.parse(toSal);
				SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
				int total=salaryCal.totalSal(fromDt, toDt);
				HttpSession session=request.getSession();
				session.setAttribute("totalAmt", total);
				RequestDispatcher dispatcher=request.getRequestDispatcher("SalaryInDate.jsp");
				dispatcher.forward(request, response);
				
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
