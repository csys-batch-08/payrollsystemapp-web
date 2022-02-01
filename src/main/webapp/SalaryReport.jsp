<%@page import="com.payroll.model.Employee"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@page import="com.payroll.dao.GradeDaoImpl"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@page import="com.payroll.model.EmpSalary"%>
<%@page import="com.payroll.dao.SalaryCalculateDaoImpl"%>
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
    background-image: url("images/pexels-masood-aslami-10786529.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>
<h2>EMPLOYEE REPORT &nbsp;</h2>


<div>
<table>
<tr class="bg-primary">
<td>EMPLOYEE ID</td>
<td>DEPARTMENT Name</td>
<td>TOTAL LEAVE</td>
<td>GRADE Name</td>
<td>SALARY DATE</td>
<td>GROSS SALARY</td>
<td>TOTAL SALARY</td>



</tr>

<c:forEach items="${sessionScope.empSalList}" var="salRep">

<tr>
<td>${salRep.emp.empId }</td>
<td>${fn:toUpperCase(salRep.dept.deptName) }</td>

<td>${salRep.totalLeave }</td>
<td>${fn:toUpperCase(salRep.grade.gradeName) }</td>
<fmt:parseDate value="${salRep.salaryDate}" pattern="yyyy-MM-dd" var="SalDate" type="date"/>   
<td ><fmt:formatDate pattern="dd-MM-yyyy" value="${SalDate}"/> </td>

<td>${salRep.gross }</td>
<td>${salRep.salary }</td>

</tr>
</c:forEach>
</table>

</div>

<br>

<form>
<center>
<a href="adminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>
 <input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
 </center>
</form>
<script>
function showReport(){
	var report=document.getElementById("report");
	report.style.display="block";
	
	
}</script>
</html>
