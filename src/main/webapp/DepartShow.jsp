<%@page import="com.payroll.model.Departments"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.DepartmentsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<title>payroll</title>
<style type="text/css">
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
tr:hover{
background-color: lime;
}
tr:nth-child(even) {background-color: #f2f2f2;}
a{
text-decoration:none;
}
.text-primary {
    margin-top: 11px;
    --bs-text-opacity: 1;
    color: rgba(var(--bs-primary-rgb),var(--bs-text-opacity))!important;
    margin-left: 573px;
}
#search{
float: right;
margin-top:10px;
margin-right: 40px;
}

</style>
</head>
<body>
<%String deptDel=(String)request.getParameter("depDelete");
if(deptDel!=null){
%>
<h3><%=deptDel %></h3>
<%session.removeAttribute("depDelete"); %>

<%} %>
<div id="search">
<form action="departmentSearch.jsp">

<input type="text" name="deptName" placeholder="Enter Department Name" autofocus="autofocus">
<button type="submit" class="btn btn-primary">&#128269;
</button>
</form>
</div>
<h3 class="text-primary">Department</h3>

&nbsp;&nbsp;

<table >
<tr class="bg-primary">
<td>DEPARTMENT ID</td>
<td>DEPARTMENT NAME</td>

<td>DELETE</td>
<td>EDIT</td>
</tr>



<% DepartmentsDaoImpl departDao=new DepartmentsDaoImpl();
List<Departments> departList=departDao.showDepartments();
for(int i=0;i<departList.size();i++)
{
	Departments departments=departList.get(i);
%>	
<tr>
<td><%=departments.getDeptId() %></td>
<td><%=departments.getDeptName() %></td>

<td><a href="departDel?deptId=<%= departments.getDeptId() %>">DELETE</a></td>
<td><a href="DepartUpd.jsp?departId=<%= departments.getDeptId() %>">EDIT</a></td>

</tr>
<%}%>
</table>
<center>
<br>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>
<input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
</center>

</body>
</html>