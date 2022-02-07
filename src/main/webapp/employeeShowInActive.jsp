
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>show inactive employee</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="asset\css\employShowInactive.css">

</head>
<body>
	<c:set var="deleteError" scope="session" value="${delete}" />
	<c:if test="${not empty deleteError}">
		<h2>
			<c:out value="${deleteError}" />
		</h2>
		<c:remove var="deleteError" scope="session" />
	</c:if>


	<div id="empShowForm">
	
		<h3 class="text-info">INACTIVE-EMPLOYEE</h3>

		<table class="table">
		<thead>
			<tr class="bg-primary">
				<th scope="col">EMPLOYEE ID</th>
				<th scope="col">EMPLOYEE NAME</th>
				<th scope="col">DATE OF BIRTH</th>
				<th scope="col">DATE OF JOINING</th>
				<th scope="col">ADDRESS</th>
				<th scope="col">CITY</th>
				<th scope="col">PINCODE</th>
				<th scope="col">MOBILE NUMBER</th>
				<th scope="col">STATE</th>
				<th scope="col">EMAIL ID</th>
				<th scope="col">PAN NUMBER</th>
				<th scope="col">DEPARTMENT NAME</th>
				<th scope="col">GRADE NAME</th>
				<th scope="col">Status</th>

			</tr>

	<thead>

			<c:forEach items="${sessionScope.showInActiveEmp}" var="emp">
				<tr>
					<td>${emp.empId}</td>
					<td>${fn:toUpperCase(emp.empName)}</td>

					<fmt:parseDate value="${emp.dob}" pattern="yyyy-MM-dd"
						var="dobDate" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${dobDate}" />
					</td>
					<fmt:parseDate value="${emp.doj}" pattern="yyyy-MM-dd"
						var="dojDate" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${dojDate}" />
					</td>

					<td>${emp.address}</td>
					<td>${emp.city }</td>
					<td>${emp.pincode }</td>
					<td>${emp.mobileNo }</td>
					<td>${emp.state }</td>
					<td>${emp.mailId }</td>
					<td>${emp.panNo }</td>
					<td>${emp.dept.deptName}</td>
					<td>${emp.grade.gradeName }</td>

					<td><a href="EmpStatus?statusId=${emp.empId}">ACTIVE</a></td>
					</tr>
			</c:forEach>
			


		</table>
	<div>

			<button onclick="history.go(-1)" class="btn btn-primary">Go
				Back</button>

			<a href="adminControl.jsp"><button type="button"
					class="btn btn-primary">
					<strong>HOME</strong>
				</button></a>
		</div>
	</div>
	
</body>
</html>