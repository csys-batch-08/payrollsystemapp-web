
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Salary Approve</title>
  <link rel="stylesheet" type="text/css" href="asset\css\salaryApprove.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>

	<form action="salaryInsert" class="style" method="post">
		
			<br>
			<div id="salsty">
			<c:forEach items="${sessionScope.salEmpApprove}" var="ApproveEmp">


				<label for="gradeName">EMPLOYEE ID</label>

				<input type="number" id="" name="empId" value="${ApproveEmp.empId }">
				<br>
				<br>
				<label for="gradeName">GRADE NAME</label>
				<input type="text" name="gName" id="gradeName"
					value="${ApproveEmp.grade.gradeName }">
				<br>
				<br>
				<label for="deptName">DEPARTMENT NAME</label>
				<input type="text" name="dName" id="deptName"
					value="${ApproveEmp.dept.deptName }">
				<br>
				<br>

			</c:forEach>
			<label for="taxDeducte">PROFESSIONAL TAX</label> <select name="tax"
				id="taxDeducte">
				<option value="yes">Yes</option>
				<option value="no">No</option>

			</select> <br> <br> <label for="monthBonus">MONTH BONUS</label> <select
				name="bonus" id="monthBonus">
				<option value="yes">Yes</option>
				<option value="no">No</option>

			</select> <br> <br> <input type="reset" name="rest"  aria-labelledby="rest" class="btn btn-primary">
			<button type="submit" class="btn btn-primary">Submit</button>
			</div>
	</form>
	<div>
	<button onclick="history.back()" class="btn btn-primary">BACK</button>
	<a href="adminControl.jsp"><button type="button"
			class="btn btn-primary">
			<strong>HOME</strong>
		</button></a>
	
	<br>
	<br>
	</div>
</body>
</html>