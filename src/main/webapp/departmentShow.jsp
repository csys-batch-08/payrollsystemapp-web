
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
	<c:set var="deptDel" scope="session" value="${depDelete}" />

	<c:if test="${not empty deptDel}">
		<h2>
			<c:out value="${deptDel}" />
			&#9888;
		</h2>
		<c:remove var="deptDel" scope="session" />
	</c:if>

	<div id="search">
		<form action="departmentSearch" method="post">
			
			<input type="text" name="deptName" 
				placeholder="Enter Department Name"  aria-label="firstname" autofocus="autofocus">
			<button type="submit" class="btn btn-primary">&#128269;</button>
		</form>
	</div>
	<fmt:bundle basename = "com.payroll.bundle.Label" prefix="nav.">
	<h3 class="text-primary"><fmt:message  key="Department"/></h3>

	&nbsp;&nbsp;

	<table>
	
	
		<tr class="bg-primary">
		
		
			<th scope="col">DEPARTMENT ID</th>
			<th scope="col">DEPARTMENT NAME</th>

			<th scope="col"><fmt:message  key="Delete"/></th>
			<th scope="col"><fmt:message  key="Edit"/></th>
			
		</tr>
	


		<c:forEach items="${sessionScope.deptList}" var="depart">

			<tr>
				<td>${depart.deptId }</td>

				<td>${fn:toUpperCase(depart.deptName)}</td>

				<td><a href="departDel?deptId=${depart.deptId }"><fmt:message  key="Delete"/></a></td>
				<td><a href="EditDept?departId=${depart.deptId }"><fmt:message  key="Edit"/></a></td>

			</tr>
		</c:forEach>
	</table>
	<div>
		 <a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong>Home Page</strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary">
	</div>
</fmt:bundle>
</body>
</html>