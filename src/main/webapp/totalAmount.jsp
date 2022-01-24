<%@page import="java.text.ParseException"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="com.payroll.dao.SalaryCalculateDaoImpl"%>
<%@page import="java.util.Date"%>
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
			System.out.println(fromSal);
			System.out.println(toSal);
			PrintWriter pw=response.getWriter();
			out.print(total);
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}%>
