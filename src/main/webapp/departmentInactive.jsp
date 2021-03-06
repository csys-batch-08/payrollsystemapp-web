
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page import="com.payroll.daoimpl.DepartmentsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="asset\css\departmentShow.css">

<title>Show Department</title>
</head>
<body>

	<h3 class="text-primary">INACTIVE DEPARTMENT</h3>

	&nbsp;&nbsp;

	<table >
	
<thead>
		<tr class="bg-primary">
		<th></th>
			<td>DEPARTMENT ID</td>
			<td>DEPARTMENT NAME</td>
			<fmt:bundle basename = "com.payroll.bundle.InputLabel" prefix="nav.">
			
			<td><fmt:message  key="Status"/></td>
			</fmt:bundle>
			
		</tr>
		</thead>

			<c:forEach items="${sessionScope.inactiveDeptList}" var="depart">

			<tr>
				<td>${depart.deptId }</td>

				<td>${fn:toUpperCase(depart.deptName)}</td>

				<td><a href="deptStatus?statusId=${depart.deptId}">ACTIVE </a></td>
				
			</tr>
			</c:forEach>
		
	</table>
	<div>
		<br> <a href="adminControl.jsp">
		<button type="button"
				class="btn btn-primary">
				<strong>Home Page</strong>
			</button></a>
			 <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary">
	</div>

</body>
</html>