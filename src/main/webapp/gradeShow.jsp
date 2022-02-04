
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">

    <title>payroll</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" type="text/css" href="asset\css\gradeShow.css">

</head>
<body>
<div id="search">
<form action="GradeSearchController" method="post">
<input type="text" name="gradeName" placeholder="search Grade" autofocus="autofocus">
<button type="submit"  class="btn btn-primary">&#128269;</button>
</form>
</div>

<h2>GRADE</h2>
<table>
<tr class="bg-primary">
<td>GRADE ID</td>
<td>GRADE NAME</td>
<td>GRADE BASIC</td>
<td>GRADE BONUS</td>
<td>PROVIDENT FUND</td>
<td>PROFESSIONAL TAX</td>
<td>DEPARTMENT NAME</td>
<td>DELETE</td>
<td>EDIT</td>
</tr>

<c:forEach items="${sessionScope.grdList}" var="grd">

	<tr>
	<td>${grd.gradeId }</td>
	<td>${fn:toUpperCase(grd.gradeName)}</td>
	
	<td>${grd.gradeBasic }</td>
	<td>${grd.gradeBonus }</td>
	
	<td>${grd.gradePf }</td>
	<td>${grd.gradePt }</td>
	<td>${grd.department.deptName }
	<td><a href="GradeDel?gradeId=${grd.gradeId }" >DELETE</a></td>
	
	<td><a href="GradeEdit?gradeId=${grd.gradeId }">EDIT</a></td>
	
	</tr>
	

</c:forEach>
</table>
<br>
<center>
<a href="adminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>

 <input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
 </center>
 
</body>
</html>