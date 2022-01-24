package com.payroll.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.payroll.dao.DepartmentsDaoImpl;
import com.payroll.dao.EmployeeDaoImpl;
import com.payroll.dao.GradeDaoImpl;
import com.payroll.exception.EmployeeDelException;
import com.payroll.model.Departments;
import com.payroll.model.Employee;
import com.payroll.model.Grade;


@WebServlet("/empUpdate")
public class EmployeeUpdController extends HttpServlet {
	

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("name");
		Date dob=null;
		Date doj=null;
		try {
			dob=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("dob"));
			doj=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("doj"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		String address=request.getParameter("address");
		
		String city=request.getParameter("city");
		long pincode=Long.parseLong(request.getParameter("pincode"));
		long mobileNo=Long.parseLong(request.getParameter("mobile"));
		String state=request.getParameter("state");
		String email=request.getParameter("email");
		
		String panNo=request.getParameter("pan");
		int departId=Integer.parseInt(request.getParameter("dId"));
		int grdId=Integer.parseInt(request.getParameter("grdId"));
		GradeDaoImpl gradeDao=new GradeDaoImpl();
		Grade grade=gradeDao.findGrade(grdId);
		DepartmentsDaoImpl departDao=new DepartmentsDaoImpl();
		Departments depart=departDao.findDepartment(departId);
		EmployeeDaoImpl employ=new EmployeeDaoImpl();
		Employee employee=employ.findEmploy(email);
		int empId=employ.findEmployeeID(employee);
		Employee emp=new Employee(empId,name,dob,doj,address,city,pincode,mobileNo,state,email,panNo,depart,grade);
		int i=employ.updateEmp(emp);
		try {
			
		
		
		if(i>0) {
			
		
		PrintWriter out =response.getWriter();
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Employee Updated Successfully');");
		out.println("location='EmpShow.jsp';");
		out.println("</script>");
		}
		else{
			throw new EmployeeDelException();
			}}
		catch(EmployeeDelException e) {
			HttpSession session=request.getSession();
			session.setAttribute("dataInvalid", e.getEmployeeEntry());
			response.sendRedirect("EmployUpd.jsp");
			
		}
		}

}
