
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Department Search</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="asset\css\departmentSearch.css">
</head>
<body>
	<div id="excepSty">
		<c:set var="dptNotSearch" scope="session"
			value="${departSearchNtFound}" />
		<c:if test="${not empty dptNotSearch}">
			<h3>
				<c:out value="${dptNotSearch}" />
				&#9888;
			</h3>
			<c:remove var="dptNotSearch" scope="session" />
		</c:if>
	</div>
	<h2>Search Department</h2>
					<fmt:bundle basename = "com.payroll.bundle.Label" prefix="nav.">
	
	<table >
	
		<thead>
		
			<tr class="bg-primary">
			
				<td>DEPARTMENT ID</td>
				<td>DEPARTMENT NAME</td>
				
				<td><fmt:message  key="Status"/></td>
				

			</tr>
		</thead>
		<c:forEach items="${sessionScope.searchDept}" var="searchdept">
			<tr>
				<td>${searchdept.deptId }</td>
				<td>${searchdept.deptName }</td>
				<td>${searchdept.status }</td>

			</tr>
			
		</c:forEach>
	</table>


	<div>
		<a href="adminControl.jsp"><button type="button"
				class="btn btn-primary"><fmt:message  key="Home"/></button></a> <input type="button"
			value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
			
	</div>
	</fmt:bundle>
</body>
</html>