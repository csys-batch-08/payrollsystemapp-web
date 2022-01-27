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

import com.payroll.dao.LeaveDaoImpl;
import com.payroll.model.Leave;

/**
 * Servlet implementation class LeaveShowController
 */
@WebServlet("/LeaveShow")
public class LeaveShowController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveDaoImpl leaveDao=new LeaveDaoImpl();
		List<Leave> leaveList=leaveDao.showLeaveDetail();
		HttpSession session=request.getSession();
		session.setAttribute("leave", leaveList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("LeaveShow.jsp");
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