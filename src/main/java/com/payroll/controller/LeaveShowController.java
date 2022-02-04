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

import com.payroll.daoimpl.LeaveDaoImpl;
import com.payroll.model.Leave;

@WebServlet("/LeaveShow")
public class LeaveShowController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LeaveDaoImpl leaveDao=new LeaveDaoImpl();
		List<Leave> leaveList=leaveDao.showLeaveDetail();
		HttpSession session=request.getSession();
		session.setAttribute("leave", leaveList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("leaveShow.jsp");
		dispatcher.forward(request, response);
	}



}
