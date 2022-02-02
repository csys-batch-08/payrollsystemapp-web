package com.payroll.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


@WebServlet("/LeaveInbetweenController")
public class LeaveInbetweenController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date fromDt=null;
		Date toDate=null;
		try{
			 toDate=sdf.parse(request.getParameter("toDate"));

			 fromDt =sdf.parse(request.getParameter("fromDt"));
		}
		catch(Exception e){
			e.getStackTrace();
		}

		LeaveDaoImpl leaveDao=new LeaveDaoImpl();
		List<Leave> leaveList=leaveDao.searchLeave(fromDt, toDate); 
		HttpSession session=request.getSession();
		session.setAttribute("leaveList", leaveList);
		RequestDispatcher dispatcher=request.getRequestDispatcher("leaveInBetweenDate.jsp");
		dispatcher.forward(request, response);
	}

	
}
