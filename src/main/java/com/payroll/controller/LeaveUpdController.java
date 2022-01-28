package com.payroll.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.LeaveDaoImpl;
import com.payroll.exception.LeaveException;
import com.payroll.model.Leave;


@WebServlet("/leaveUpd")
public class LeaveUpdController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date leaveDt=null;
		try {
			leaveDt=sdf.parse(request.getParameter("leaveDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String reason=request.getParameter("reason");
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
