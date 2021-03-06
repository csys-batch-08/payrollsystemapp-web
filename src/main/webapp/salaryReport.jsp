
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
  <link rel="stylesheet" type="text/css" href="asset\css\salaryReport.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<h2>EMPLOYEE REPORT &nbsp;</h2>


	<div>
		<table>
			<tr class="bg-primary">
				<th scope="col">EMPLOYEE ID</th>
				<th scope="col">DEPARTMENT Name</th>
				<th scope="col">TOTAL LEAVE</th>
				<th scope="col">GRADE Name</th>
				<th scope="col">SALARY DATE</th>
				<th scope="col">GROSS SALARY</th>
				<th scope="col">TOTAL SALARY</th>



			</tr>

			<c:forEach items="${sessionScope.empSalList}" var="salRep">

				<tr>
					<td>${salRep.emp.empId }</td>
					<td>${fn:toUpperCase(salRep.dept.deptName) }</td>

					<td>${salRep.totalLeave }</td>
					<td>${fn:toUpperCase(salRep.grade.gradeName) }</td>
					<fmt:parseDate value="${salRep.salaryDate}" pattern="yyyy-MM-dd"
						var="SalDate" type="date" />
					<td><fmt:formatDate pattern="dd-MM-yyyy" value="${SalDate}" />
					</td>

					<td>${salRep.gross }</td>
					<td>${salRep.salary }</td>

				</tr>
			</c:forEach>
		</table>

	</div>

	<br>


		
			<a href="adminControl.jsp"><button type="button"
					class="btn btn-primary">
					<strong>Home Page</strong>
				</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
				class="btn btn-primary">
		
	
	<script>
		function showReport() {
			var report = document.getElementById("report");
			report.style.display = "block";

		}
	</script>
</html>
