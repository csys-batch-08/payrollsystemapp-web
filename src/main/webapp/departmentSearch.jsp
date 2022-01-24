<%@page import="com.payroll.model.Departments"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.DepartmentsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Search</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
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
tr:nth-child(odd) {
background-color: #40E0D0;
}
</style>
</head>
<body>
<h2>Search Department</h2>
<table>
<tr class="bg-primary">
<td>DEPARTMENT ID</td>
<td>DEPARTMENT NAME</td>

</tr>

<%String name=request.getParameter("deptName");
DepartmentsDaoImpl departmentDao=new DepartmentsDaoImpl();
List<Departments> departmentList=departmentDao.searchDepartment(name);
for(int i=0;i<departmentList.size();i++)
{
Departments depart=departmentList.get(i);
%>
<tr>
<td><%=depart.getDeptId() %></td>
<td><%=depart.getDeptName() %></td>

</tr>
<%} %>
</table>


<center>
<br>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary">HOME</button></a>
<input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
</center>
</body>
</html>