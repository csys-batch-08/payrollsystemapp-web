<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="asset\css\gradeAdd.css">

</head>
<body>

	<c:set var="negative" scope="session" value="${negativeValue}" />
	<c:if test="${not empty negative}">
		<h2>
			<c:out value="${negative}" />
		</h2>
		<c:remove var="negative" scope="session" />
	</c:if>


	<c:set var="gradeExist" scope="session" value="${alreadyGrade}" />
	<c:if test="${not empty gradeExist}">
		<h2>
			<c:out value="${gradeExist}" />
		</h2>
		<c:remove var="gradeExist" />
	</c:if>



	<h2>ADD GRADE</h2>
	<br>
	<div class="formDiv">
		<div id="gradeAdd">
			<form action="gradeAdd" method="post">

				<br> <label for="gradeNa">GRADE NAME</label> <input type="text"
					name="gradeName" id="gradeNa" pattern="[a-zA-z\s]+"
					placeholder="enter grade Name" autofocus="autofocus"> <br>
				<br> <label for="gradeBasic">BASIC SALARY</label> <input
					type="number" name="basic" id="gradeBasic" pattern="[0-9]+" min="1"
					placeholder="enter basic salary"> <br> <br> <label
					for="gradeBonus">GRADE BONUS</label> <input type="number"
					name="bonus" id="gradeBonus" pattern="[0-9]+" min="1"
					placeholder="enter bonus amount"> <br> <br> <label
					for="gradePf">PROVIDENT FUND</label> <input type="number" name="pf"
					id="gradePf" pattern="[0-9]+" min="1"
					placeholder="enter providient fund "> <br> <br> <label
					for="gradePt">PROFESSIONAL TAX</label> <input type="number"
					name="pt" id="gradePt" pattern="[0-9]+" min="1"
					placeholder="enter Professional tax "> <br> <br>
				<label for="deptName">DEPARTMENT Name</label> <input type="text"
					name="deptNa" id="deptName" pattern="[a-zA-Z]+"
					placeholder="enter Department Name "> <br> <br> <input
					type="submit" class="btn btn-primary">

			</form>
			<button onclick="history.go(-1)" class="btn btn-primary">BACK</button>
			<a href="adminControl.jsp"><button type="button"
					class="btn btn-primary">HOME</button></a>





		</div>

	</div>
</body>
</html>