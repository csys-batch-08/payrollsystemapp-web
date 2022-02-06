
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>search grade</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="asset\css\gradeSearch.css">

</head>
<body>
	<div id="excepSty">
		<c:set var="searchGrd" scope="session" value="${grdSearchNtFound}" />
		<c:if test="${not empty searchGrd}">
			<h2>
				<c:out value="${searchGrd}" />
				&#9888;
			</h2>
			<c:remove var="searchGrd" scope="session" />
		</c:if>
	</div>
	<h2>Search Grade</h2>
	<table>
		<tr class="bg-primary">
		
			<td>GRADE ID</td>
			<td>GRADE NAME</td>
			<td>BASIC</td>
			<td>BONUS</td>
			<td>PROVIDENT FUND</td>
			<td>PROFESSIONAL TAX</td>
			<td>DEPARTMENT NAME</td>
		</tr>

		<c:forEach items="${sessionScope.searchListGrade}" var="gradeSearch">

			<tr>
				<td>${gradeSearch.gradeId }</td>
				<td>${gradeSearch.gradeName }</td>
				<td>${gradeSearch.gradeBasic }</td>
				<td>${gradeSearch.gradeBonus }</td>

				<td>${gradeSearch.gradePf }</td>
				<td>${gradeSearch.gradePt }</td>
				<td>${gradeSearch.department.deptName }
			</tr>
		</c:forEach>
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