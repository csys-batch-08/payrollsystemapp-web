
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
  <link rel="stylesheet" type="text/css" href="asset\css\leaveShow.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div>
		<form action="LeaveInbetweenController" method="post">

			<label for="leaveFrom">FromDate</label> <input type="date"
				id="leaveFrom" name="fromDt"> <label for="leaveTo">ToDate</label>
			<input type="date" id="leaveTo" name="toDate">
			<button type="submit" class="btn btn-primary">&#128269;</button>
		</form>


	</div>
	<c:set var="deleteLeave" scope="session" value="${deleteLeave}" />
	<c:if test="${not empty deleteLeave}">
		<h2>
			<c:out value="${deleteLeave}" />
		</h2>
	</c:if>

	<c:set var="updleave" scope="session" value="${updLeave}" />
	<c:if test="${not empty updleave}">
		<h2>
			<c:out value="${updleave}" />
		</h2>
	</c:if>

	<table>
	
		<tr class="bg-primary">
			<th scope="col">EMPLOYEE ID</th>
			<th scope="col">EMPLOYEE NAME</th>
			<th scope="col">LEAVE DATE</th>
			<th scope="col">REASON</th>
			<th scope="col">DELETE</th>
			<th scope="col">EDIT</th>
		</tr>

		<c:forEach items="${sessionScope.leave}" var="allLeave">

			<tr>
				<td>${allLeave.employ.empId }</td>
				<td>${fn:toUpperCase(allLeave.employ.empName)}</td>

				<fmt:parseDate value="${allLeave.leaveDt}" pattern="yyyy-MM-dd"
					var="leaveDate" type="date" />
				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${leaveDate}" />
				</td>
				<td>${allLeave.leaveReason }</td>
				<td><a href="empLeave?leaveId=${allLeave.leaveId }">DELETE</a></td>
				<td><a href="LeaveEdit?leaveId=${allLeave.leaveId }">EDIT</a></td>
			</tr>
		</c:forEach>
	</table>

	
	<div>


		<a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong>HOME</strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary">
	</div>
</body>
</html>