<%@page import="com.payroll.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
    
     body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/pexels-nataliya-vaitkevich-6863259.jpg");
     background-repeat:no-repeat center center fixed;
   
  background-size: cover;
  height: 100%;
    }
    table {
  border-collapse: collapse;
  width: 100%;
}

 td,th {
  text-align: left;
  padding: 8px;
}
tr:hover{
background-color: lime;
}

tr:nth-child(even) {
background-color: #f2f2f2;
}
a{
text-decoration:none;
}
.text-info {
    margin-top: 10px;
    --bs-text-opacity: 1;
    color: rgba(var(--bs-info-rgb),var(--bs-text-opacity))!important;
    margin-left: 69px;
}
    </style>
</head>
<body>
<%String deleteError=(String)session.getAttribute("delete");
if(deleteError!=null){
%>
	<h2><%=deleteError %></h2>
	<%session.removeAttribute("delete"); %>
<%} %>

<div id="empShowForm" >
<h3  class="text-info">INACTIVE-EMPLOYEE</h3>
<form >
<table class="table">
<tr   class="bg-primary">
<td>EMPLOYEE ID</td>
<td>EMPLOYEE NAME</td>
<td>DATE OF BIRTH</td>
<td>DATE OF JOINING</td>
<td>ADDRESS</td>
<td>CITY</td>
<td>PINCODE</td>
<td>MOBILE NUMBER</td>
<td>STATE</td>
<td>EMAIL ID</td>
<td>PAN NUMBER</td>
<td>DEPARTMENT NAME</td>
<td>GRADE NAME</td>
<td>Status</td>

</tr>


<%EmployeeDaoImpl employeeDao=new  EmployeeDaoImpl();
List<Employee> employeeList=employeeDao.showInactiveEmployee();
for(int i=0;i<employeeList.size();i++)
{
	Employee emp=employeeList.get(i);
	
%>
<tr>
<td><%=emp.getEmpId() %></td>
<td><%= emp.getEmpName() %></td>
<td><%= emp.getDob() %></td>
<td><%= emp.getDoj() %></td>
<td><%= emp.getAddress() %></td>
<td><%= emp.getCity() %></td>
<td><%= emp.getPincode() %></td>
<td><%= emp.getMobileNo() %></td>
<td><%= emp.getState() %></td>
<td><%= emp.getMailId() %></td>
<td><%= emp.getPanNo() %></td>
<td><%= emp.getDept().getDeptName()%></td>
<td><%=emp.getGrade().getGradeName()%></td>

<td><a href="EmpStatus?statusId=<%= emp.getEmpId() %>">Active</a></td>
</tr>
<%} %> 

</table>
<center>

</form>
<button onclick="history.go(-1)" class="btn btn-primary">Go Back</button>

<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>
</center>
</div>
<br>
</body>
</html>