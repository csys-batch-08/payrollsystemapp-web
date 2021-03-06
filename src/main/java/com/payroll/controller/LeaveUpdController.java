package com.payroll.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.daoimpl.LeaveDaoImpl;
import com.payroll.exception.LeaveException;
import com.payroll.model.Leave;


@WebServlet("/leaveUpd")
public class LeaveUpdController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LeaveDaoImpl leaveDao=new LeaveDaoImpl();
		HttpSession session=request.getSession();
		int leaveId=(Integer)request.getAttribute("leaveId");
		Leave leave=leaveDao.findLeave(leaveId);
		int i=leaveDao.updateLeave(leave);
		try {
		if(i>0) {
			response.sendRedirect("leaveShow.jsp");
		}
		else {
			throw new LeaveException();
		}}
		catch(LeaveException e) {
			session.setAttribute("updLeave",e.getMessage2());
			response.sendRedirect("leaveShow.jsp");
			
		}
		
		
	}

}
