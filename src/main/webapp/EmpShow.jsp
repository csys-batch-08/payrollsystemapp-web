<%@page import="com.payroll.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@page import="com.payroll.Interface.EmployeeDao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<c:set var = "deleteError" scope = "session" value = "${delete}"/>
	<c:if test="${not empty deleteError}">
			<h2><c:out value="${deleteError}" /></h2>
		</c:if>

<c:set var = "delEmp" scope = "session" value = "${employDel}"/>
	<c:if test="${not empty delEmp}">
			<h2><c:out value="${delEmp}" /></h2>
		</c:if>

<div id="search">
<form action="searchEmployee">
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

<tr>
<c:forEach items="${sessionScope.empList}" var="emp">
<td>${emp.empId}</td>
<td >${emp.empName}</td>
<fmt:parseDate value="${emp.dob}" pattern="yyyy-MM-dd" var="dobDate" type="date"/>   
<td ><fmt:formatDate pattern="dd-MM-yyyy" value="${dobDate}"/> </td>

<fmt:parseDate value="${emp.doj}" pattern="yyyy-MM-dd" var="dojDate" type="date"/>   
<td ><fmt:formatDate pattern="dd-MM-yyyy" value="${dojDate}"/> </td>
<td>${emp.address}</td>
<td >${emp.city }</td>
<td >${emp.pincode }</td>
<td >${emp.mobileNo }</td>
<td >${emp.state }</td>
<td >${emp.mailId }</td>
<td >${emp.panNo }</td>
<td >${emp.dept.deptName}</td>
<td>${emp.grade.gradeName }</td>
<td ><a href="empDel?empId=${emp.empId }" >DELETE</a></td>
<td ><a href="UpdEmp?empId=${emp.empId }">EDIT</a></td>
</tr>

</c:forEach>
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