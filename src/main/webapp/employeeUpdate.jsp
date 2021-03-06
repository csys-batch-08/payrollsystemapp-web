
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>employee update</title>
<link rel="stylesheet" type="text/css" href="asset\css\employUpdate.css">



</head>
<body>
	<c:set var="data" scope="session" value="${dataInvalid}" />
	<c:if test="${not empty data}">
		<h2>
			<c:out value="${data}" />
		</h2>
		<c:remove var="data" scope="session" />
	</c:if>

	<div class="empDiv">

		<h3 class="text-warning">EMPLOYEE UPDATE</h3>
		<br>

		<form action="empUpdate" class="formSty" method="post">

			
				<br>
				<table>
					<c:forEach items="${sessionScope.editEmployee }" var="employ">

						<tr>
						
							<th scope="col"><label for="empName">EMPLOYEE NAME</label></th>
							<td><input type="text" id="empName" name="name"
								autofocus="autofocus" value="${employ.empName }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empDob">DATE OF BIRTH</label></th>
							<td><input type="date" id="empDob" name="dob"
								value="${employ.dob }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empDoj">DATE OF JOINING</label></th>
							<td><input type="date" id="empDoj" name="doj"
								value="${employ.doj }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empAddress">ADDRESS</label></th>
							<td><input type="text" id="empAddress" name="address"
								value="${employ.address }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empCity">CITY</label></th>
							<td><input type="text" id="empCity" name="city"
								value="${employ.city }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empPin">PINCODE</label></th>
							<td><input type="number" maxlength="6" id="empPin"
								name="pincode" value="${employ.pincode }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empNo">MOBILE NUMBER</label></th>
							<td><input type="number" id="empNo" maxlength="10"
								name="mobile" value="${employ.mobileNo }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empState">STATE</label></th>
							<td><input type="text" id="empState" name="state"
								value="${employ.state }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empEmail">EMAIL ID</label></th>
							<td><input type="text" id="empEmail" name="email"
								value="${employ.mailId }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empPan">PAN NUMBER</label></th>
							<td><input type="text" id="empPan" maxlength="10" name="pan"
								value="${employ.panNo }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="empDepart">DEPARTMENT ID</label></th>
							<td><input type="text" id="empDepart" name="dId"
								value="${employ.dept.deptId }"><br>
							<br></td>
						</tr>
						<tr>
							<th scope="col"><label for="gradeId">GRADE ID</label></th>
							<td><input id="gradeId" type="number" min="1" name="grdId"
								value="${employ.grade.gradeId}"><br>
							<br></td>
						</tr>
					</c:forEach>
				</table>

				<input type="submit" class="btn btn-primary">
		</form>
		<a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong>HOME</strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary"> <br>
		<br>
	</div>


</body>
</html>
<script>
	today();
	function today() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		var yyyy1 = today.getFullYear() - 24;
		maxdate = yyyy1 + '-' + mm + '-' + dd;

		document.getElementById("dob").setAttribute("max", maxdate);

	}
</script>
<script>
	today();
	function today() {
		var today = new Date();
		var dd = String(today.getDate()).padStart(2, '0');
		var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		var yyyy = today.getFullYear();
		var yyyy1 = today.getFullYear() - 9;
		maxdate = yyyy + '-' + mm + '-' + dd;
		mindate = yyyy1 + '-' + mm + '-' + dd;
		document.getElementById("doj").setAttribute("max", maxdate);
		document.getElementById("doj").setAttribute("min", mindate);
	}
</script>