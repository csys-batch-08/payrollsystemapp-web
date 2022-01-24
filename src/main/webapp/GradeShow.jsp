<%@page import="com.payroll.model.Grade"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.GradeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style>
    #search {
    margin-left: 1045px;
    margin-top: 10px;
}
    body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/pexels-masood-aslami-10786529.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
a{
text-decoration: none;
}
.h2, h2 {
    margin-left: 600px;
    font-size: 2rem;
}
    </style>
    <title>payroll</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div id="search">
<form action="gradeSearch.jsp">
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


<%GradeDaoImpl gradeDao=new GradeDaoImpl();
List<Grade> gradeList=gradeDao.showGrade();
for(int i=0;i<gradeList.size();i++){
	Grade grade=gradeList.get(i);
	
	%>
	<tr>
	<td><%=grade.getGradeId() %></td>
	<td><%= grade.getGradeName() %></td>
	<td><%= grade.getGradeBasic() %></td>
	<td><%= grade.getGradeBonus() %></td>
	
	<td><%= grade.getGradePf() %></td>
	<td><%= grade.getGradePt() %></td>
	<td><%=grade.getDepartment().getDeptName() %>
	<td><a href="GradeDel?gradeId=<%= grade.getGradeId() %>" >DELETE</a></td>
	
	<td><a href="GradeUpd.jsp?gradeId=<%= grade.getGradeId() %>">EDIT</a></td>
	
	</tr>
	

<%} %>
</table>
<br>
<center>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>

 <input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
 </center>
 
</body>
</html>