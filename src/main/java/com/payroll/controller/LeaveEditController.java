package com.payroll.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.LeaveDaoImpl;
import com.payroll.model.Grade;
import com.payroll.model.Leave;

/**
 * Servlet implementation class LeaveEditController
 */
@WebServlet("/LeaveEdit")
public class LeaveEditController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int leaveId=Integer.parseInt(request.getParameter("leaveId"));
		HttpSession session1=request.getSession();
		session1.setAttribute("leaveId", leaveId);
		LeaveDaoImpl leaveDao=new LeaveDaoImpl();
		Leave leaveList=leaveDao.findLeave(leaveId);
		List<Leave> leave=new ArrayList<Leave>();
		leave.add(leaveList);
		session1.setAttribute("leave", leave);
		RequestDispatcher dispatcher=request.getRequestDispatcher("LeaveUpd.jsp");
		dispatcher.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}