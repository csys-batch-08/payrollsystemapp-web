<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.payroll.dao.SalaryCalculateDaoImpl"%>
<%@page import="java.util.Date"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			String fromSal=request.getParameter("fromSal");
			String toSal=request.getParameter("toSal");
			Date fromDt=sdf.parse(fromSal);
			Date toDt=sdf.parse(toSal);
			SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
			int total=salaryCal.totalSal(fromDt, toDt);
			
			session.setAttribute("totalAmt", total);
			RequestDispatcher dispatcher=request.getRequestDispatcher("SalaryInDate.jsp");
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}%>
