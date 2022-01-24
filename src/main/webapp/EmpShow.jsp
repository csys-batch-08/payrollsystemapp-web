<%@page import="com.payroll.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@page import="com.payroll.Interface.EmployeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
    
     body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/pexels-nataliya-vaitkevich-6863183.jpg") ;
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
#search{
float: right;
margin-top:10px;
margin-right: 40px;
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
<%String delEmp=(String)session.getAttribute("employDel");
if(delEmp!=null){
%>
	<h2><%=delEmp %></h2>
	<%session.removeAttribute("employDel"); %>
	
<%} %>
<div id="search">
<form action="searchEmployee.jsp">
<div class="input-group">

<input type="search" name="empName" placeholder="Search Employee Name" class="form-control"  autofocus="autofocus">

<button type="submit"  class="btn btn-primary">&#128269;</button>
</div>
</form>


</div>
<div id="empShowForm" >
<h3 class="text-warning">ACTIVE EMPLOYEE</h3>
&nbsp;&nbsp;

<form >
<div class="gridtable">
<table >

<tr class="bg-primary">
<td>EMPLOYEE ID</td>
<td >EMPLOYEE NAME</td>
<td >DATE OF BIRTH</td>
<td >DATE OF JOINING</td>
<td >ADDRESS</td>
<td >CITY</td>
<td >PINCODE</td>
<td >MOBILE NUMBER</td>
<td >STATE</td>
<td>EMAIL ID</td>
<td >PAN NUMBER</td>
<td >DEPARTMENT NAME</td>
<td>GRADE NAME</td>
<td >DELETE</td>
<td >EDIT</td>

</tr>


<%EmployeeDaoImpl employeeDao=new  EmployeeDaoImpl();
List<Employee> employeeList=employeeDao.showEmployee();
for(int i=0;i<employeeList.size();i++)
{
	Employee emp=employeeList.get(i);
%>

<tr>
<td><%=emp.getEmpId() %></td>
<td ><%= emp.getEmpName() %></td>
<td ><%= emp.getDob() %></td>
<td ><%= emp.getDoj() %></td>
<td><%= emp.getAddress() %></td>
<td ><%= emp.getCity() %></td>
<td ><%= emp.getPincode() %></td>
<td ><%= emp.getMobileNo() %></td>
<td ><%= emp.getState() %></td>
<td ><%= emp.getMailId() %></td>
<td ><%= emp.getPanNo() %></td>
<td ><%= emp.getDept().getDeptName()%></td>
<td><%=emp.getGrade().getGradeName() %>
<td ><a href="empDel?empId=<%= emp.getEmpId() %>" >DELETE</a></td>
<td ><a href="EmployUpd.jsp?empId=<%= emp.getEmpId() %>">EDIT</a></td>
</tr>
<%} %>

</table>
</div>

<br>


</form>
<center>
<button onclick="history.go(-1)" class="btn btn-primary">Go Back</button>

<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>
<br><br>
</center>
</div>
<br>
</body>
</html>