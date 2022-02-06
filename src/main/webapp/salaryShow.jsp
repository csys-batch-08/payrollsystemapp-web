
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Show SalaryEmploy</title>
<link rel="stylesheet" type="text/css" href="asset\css\salaryShow.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div id="mySidenav" class="sidenav">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="totalSal">Salary Count</a> <a href="salaryInBetweenDate.jsp">Salary
			In-between</a>

	</div>
	<div id="main">
		<span style="font-size: 30px; cursor: pointer" onkeypress="openNav()">&#9776;
			SALARY</span>

		<table>

			<tr class="bg-primary">
				<td>EMPLOYEE ID</td>
				<td>DEPARTMENT NAME</td>
				<td>GRADE NAME</td>
				<td>TOTAL LEAVE</td>
				<td>SALARY DATE</td>
				<td>GROSS SALARY</td>
				<td>ACTUAL SALARY</td>
				<td>DELETE</td>
			</tr>

			<c:forEach items="${sessionScope.salaryShowList}" var="salaryShowL">
				<tr>
					<td>${salaryShowL.emp.empId}</td>
					<td>${salaryShowL.dept.deptName}</td>
					<td>${salaryShowL.grade.gradeName}</td>
					<td>${salaryShowL.totalLeave}</td>
					<fmt:parseDate value="${salaryShowL.salaryDate}"
						pattern="yyyy-MM-dd" var="salDt" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${salDt}" />
					</td>

					<td>${salaryShowL.gross}</td>
					<td>${salaryShowL.salary}</td>
					<td><a href="salDel?salId=${salaryShowL.transId }">DELETE</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div>
		<br> <a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong>Home Page</strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary">
	</div>

</body>
</html>
<script>
	function openNav() {
		document.getElementById("mySidenav").style.width = "250px";
		document.getElementById("main").style.marginLeft = "250px";
	}

	function closeNav() {
		document.getElementById("mySidenav").style.width = "0";
		document.getElementById("main").style.marginLeft = "0";
	}
</script>