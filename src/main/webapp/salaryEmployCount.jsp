<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Total Employee Salary</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
	background-image:
		url("asset/images/carlos-muza-hpjSkU2UYSU-unsplash.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.salStyle {
	padding: 33px 32px;
	border-radius: 25px;
	width: 30%;
	background-color: #bcbce5;
	margin-left: 793px;
	margin-top: 136px;
}

#bacSy {
	margin-top: 4px;
	margin-left: 139px;
}
</style>
</head>
<body>
	<c:set var="empActive" scope="session" value="${actEmp}" />
	<c:set var="empinActive" scope="session" value="${inactEmp}" />
	<c:set var="salCt" scope="session" value="${salCount}" />

	<div class="salStyle">
		<table>
			<tr>
				<td><label for="actEmp">ACTIVE EMPLOYEE</label></td>
				<td><input id="actEmp" name="empAct" value="${empActive}">
				</td>
			</tr>
			<tr>
				<td><label for="inactEmp">IN-ACTIVE EMPLOYEE</label></td>
				<td><input id="inactEmp" name="empInact" value="${empinActive}">
				</td>
			</tr>
			<tr>
				<td><label for="salApprove">SALARY APPROVED EMPLOYEE</label></td>
				<td><input id="salApprove" name="salEmp" value="${salCt}">
				</td>
			</tr>
		</table>
		<div id="bacSy">
			<a href="adminControl.jsp"><button type="button"
					class="btn btn-primary">HOME</button></a> <input type="button"
				value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
		</div>
	</div>
</body>
</html>