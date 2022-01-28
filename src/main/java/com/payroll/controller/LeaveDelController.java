package com.payroll.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.LeaveDaoImpl;
import com.payroll.exception.LeaveException;
import com.payroll.model.Leave;

/**
 * Servlet implementation class LeaveDelController
 */
@WebServlet("/empLeave")
public class LeaveDelController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int leaveId=Integer.parseInt(request.getParameter("leaveId"));
		LeaveDaoImpl leaveDao=new LeaveDaoImpl();
		Leave leave=leaveDao.findLeave(leaveId);
		int i=leaveDao.deleteLeave(leave);
		try{
			if(i>0) {
		
			response.sendRedirect("leaveShow.jsp");
		}
		else {
			throw new LeaveException();
		}}
		catch(LeaveException e) {
			HttpSession session=request.getSession();
			session.setAttribute("deleteLeave", e.getMessage());
			response.sendRedirect("leaveShow.jsp");
		}
		
	}

}
