
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>employ show</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="asset\css\employShow.css">

</head>
<body>

	<div id="exceptSty">	
<c:set var = "deleteError" scope = "session" value = "${delete}"/>
	<c:if test="${not empty deleteError}">
			<h2><c:out value="${deleteError}" />&#9888;</h2>
				<c:remove var="deleteError" scope="session"/> 
		</c:if>

<c:set var = "delEmp" scope = "session" value = "${employDel}"/>
	<c:if test="${not empty delEmp}">
			<h2><c:out value="${delEmp}" />&#9888;</h2>
		<c:remove var="delEmp" scope="session"/> 
		</c:if>
</div>
<div id="search">
<form action="searchEmployee" method="post">
<div class="input-group">

<input type="search" name="empName" placeholder="Search Employee Name" class="form-control"  autofocus="autofocus">

<button type="submit"  class="btn btn-primary">&#128269;</button>
</div>
</form>


</div>
<div id="empShowForm" >
<h3 class="text-warning">ACTIVE EMPLOYEE</h3>
&nbsp;&nbsp;


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

 <c:set var = "empName" value = "${fn:toUpperCase(emp.empName)}" />
<td >${empName}</td>

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


<center>
<button onclick="history.go(-1)" class="btn btn-primary">Go Back</button>

<a href="adminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>
<br><br>
</center>
</div>
<br>
</body>
</html>