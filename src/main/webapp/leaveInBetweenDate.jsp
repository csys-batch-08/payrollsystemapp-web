

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Search Leave Date</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="asset\css\leaveInBetweenDate.css">

</head>
<body>
	<h2>BETWEEN LEAVE DATE</h2>

	<table>

		<tr class="bg-primary">
			<td>LEAVE ID</td>
			<td>EMPLOYEE ID</td>
			<td>LEAVE DATE</td>
			<td>REASON</td>
		</tr>



		<c:forEach items="${sessionScope.leaveList}" var="leaveList">

			<tr>
				<td>${leaveList.leaveId }</td>
				<td>${leaveList.employ.empId }</td>
				<fmt:parseDate value="${leaveList.leaveDt}" pattern="yyyy-MM-dd"
					var="leaveDate" type="date" />
				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${leaveDate}" />
				</td>
				<td>${leaveList.leaveReason}</td>

			</tr>

		</c:forEach>

	</table>
	<center>
		<br> <a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong>Home Page</strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary">
	</center>
</body>
</html>