
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>search employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="asset\css\employeeSearch.css">

</head>
<body>
	<div id="excepSty">
		<c:set var="empNotSearch" scope="session" value="${searchNtFound}" />
		<c:if test="${not empty empNotSearch}">
			<h2>
				<c:out value="${empNotSearch}" />
				&#9888;
			</h2>
			<c:remove var="empNotSearch" scope="session" />

		</c:if>
	</div>
	<div id="seaID">
		<h2>Search Employee</h2>
	</div>
	<table>
	<thead>
			<fmt:bundle basename = "com.payroll.bundle.Label" prefix="nav.">
	
		<tr class="bg-primary">
			<td>EMPLOY ID</td>
			<td>EMPLOY NAME</td>
			<td><fmt:message  key="Dob"/></td>
			<td><fmt:message  key="Doj"/></td>
			<td><fmt:message  key="Address"/></td>
			<td><fmt:message  key="City"/></td>
			<td><fmt:message  key="Pincode"/></td>
			<td>MOBILE NO</td>
			<td><fmt:message  key="State"/></td>
			<td><fmt:message  key="Email"/></td>
			<td>PAN NUMBER</td>
			<td><fmt:message  key="Status"/></td>
			<td>DEPARTMENT NAME</td>
			<td>GRADE NAME</td>

		</tr>
		</fmt:bundle>
</thead>

		
			<tr>
			<div id="empInfo">
				<c:forEach items="${sessionScope.searchEmp}" var="searchEmploy">

					<td>${searchEmploy.empId}</td>
					<td>${searchEmploy.empName}</td>
					<fmt:parseDate value="${searchEmploy.dob}" pattern="yyyy-MM-dd"
						var="dobDate" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${dobDate}" />
					</td>
					<fmt:parseDate value="${searchEmploy.doj}" pattern="yyyy-MM-dd"
						var="dojDate" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${dojDate}" />
					</td>

					<td>${searchEmploy.address}</td>
					<td>${searchEmploy.city }</td>
					<td>${searchEmploy.pincode }</td>
					<td>${searchEmploy.mobileNo }</td>
					<td>${searchEmploy.state }</td>
					<td>${searchEmploy.mailId }</td>
					<td>${searchEmploy.panNo }</td>
					<td>${searchEmploy.status }</td>
					<td>${searchEmploy.dept.deptName}</td>
					<td>${searchEmploy.grade.gradeName }</td>
				</c:forEach>
				</div>
			</tr>

		

	</table>
	
	<div>
		<a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong>Home Page</strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary">
	</div>
</body>
</html>