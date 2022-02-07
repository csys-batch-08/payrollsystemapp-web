<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Department Add</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="asset\css\departmentSearch.css">

</head>
<body>
	<div id="excepError">
		<c:set var="deptError" scope="session" value="${departAlready}" />
		<c:if test="${not empty deptError}">
			<h3>
				<c:out value="${deptError}" />
				&#9888;
			</h3>
			<c:remove var="deptError" scope="session" />
		</c:if>
	</div>

	<div class="formSty">
		<form action="deptAdd" method="post">

<fmt:bundle basename = "com.payroll.bundle.Label" prefix="nav.">
			<label for="deptName">DEPARTMENT NAME</label> 
			<input type="text"
				id="deptName" name="dptname" autofocus="autofocus"
				placeholder="enter department name"><br> <br> 
				<input
				type="submit" class="btn btn-primary"> 
				<input type="reset"	name="firstname" aria-label="firstname" class="btn btn-primary"> 
				<a href="adminControl.jsp">
				<button
					type="button" class="btn btn-primary"><fmt:message key="Home"/></button></a> <br>
					   </fmt:bundle>
		</form>


	</div>


</body>
</html>