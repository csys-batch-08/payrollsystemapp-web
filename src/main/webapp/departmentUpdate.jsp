
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Department update</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="asset\css\departmentUpdate.css">

</head>
<body>
	<c:set var="deptUpd" scope="session" value="${deptUpdData}" />

	<c:if test="${not empty deptUpd}">
		<h2>
			<c:out value="${deptUpd}" />
		</h2>
		<c:remove var="deptUpd" scope="session" />
	</c:if>

	<c:forEach items="${sessionScope.department}" var="department">

		<form action="deptUpd" method="post">
			<br> <br>


			<div class="formSty">
				<br> <label for="deptName">DEPARTMENT NAME</label> <input
					type="text" id="deptName" name="name" autofocus="autofocus"
					value="${department.deptName }"><br> <br> <input
					type="submit" class="btn btn-primary">
			</div>
		</form>

	</c:forEach>
	
	<div>
		<fmt:bundle basename = "com.payroll.bundle.Label" prefix="nav.">
	
		<a href="adminControl.jsp"><button type="button"
				class="btn btn-primary"><fmt:message  key="Home"/></button></a>
				</fmt:bundle>

		<button onclick="history.go(-1)" class="btn btn-primary">GO
			BACK</button>
	</div>


</body>
</html>
