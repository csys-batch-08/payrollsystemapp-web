
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search grade</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
    body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("asset/images/pexels-masood-aslami-10786529.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    
table {
  border-collapse: collapse;
  width: 100%;
}

 td,th {
  text-align: left;
  padding: 8px;
}
tr:hover{
background-color: lime;
}

tr:nth-child(even) {
background-color: #f2f2f2;
}
</style>
</head>
<body>
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
<center>
<a href="adminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>

 <input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
 </center>
</body>
</html>