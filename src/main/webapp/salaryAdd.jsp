
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
  <link rel="stylesheet" type="text/css" href="asset\css\salaryAdd.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>

</style>
</head>
<body>
	<c:set var="salStatus" scope="session" value="${statusSal}" />
	<c:if test="${not empty salStatus}">
		<h2>
			<c:out value="${salStatus}" />
		</h2>
		<c:remove var="salStatus" />
	</c:if>

	<c:set var="salInvalid" scope="session" value="${salaryEntry}" />
	<c:if test="${not empty salInvalid}">
		<h2>
			<c:out value="${salInvalid}" />
		</h2>
		<c:remove var="salInvalid" />
	</c:if>

	<c:set var="InvalidEnter" scope="session" value="${DateSal}" />
	<c:if test="${not empty InvalidEnter}">
		<h2>
			<c:out value="${InvalidEnter}" />
		</h2>
		<c:remove var="InvalidEnter" />
	</c:if>
	<c:set var="notFoundEmp" scope="session" value="${notFoundEmp}" />
	<c:if test="${not empty notFoundEmp}">
		<h2>
			<c:out value="${notFoundEmp}" />
		</h2>
		<c:remove var="notFoundEmp" />
	</c:if>

	<h1>
		<STRONG>ADMINISTRATOR &nbsp;</STRONG>
	</h1>

	<form action="ASE" class="formSty" method="post">
		<br> <label for="employId">EMPLOYEE ID</label> <input
			type="number" name="eId" id="employId" min="1" pattern="[0-9]+"
			placeholder="enter employ Id"><br>
		<br> <input type="reset" class="btn btn-primary"> <input
			type="submit" class="btn btn-primary"> <a
			href="adminControl.jsp"><button type="button"
				class="btn btn-primary">HOME</button></a> <br>
		<br>
	</form>

</body>
</html>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var yyyy1= today.getFullYear()-24;
maxdate =yyyy1 + '-' + mm + '-'+ dd  ;

document.getElementById("salaryDate").setAttribute("max",maxdate);

}
</script>
