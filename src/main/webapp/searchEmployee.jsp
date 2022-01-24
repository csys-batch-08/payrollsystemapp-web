<%@page import="com.payroll.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search employee</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
#seaID {
    margin-left: 568px;
}


tr:nth-child(even) {
background-color: #f2f2f2;
}
</style>
</head>
<body>
<div id="seaID">
<h2>Search Employee</h2>
</div>
<table>
<tr class="bg-primary">
<td>EMPLOY ID</td>
<td>EMPLOY NAME</td>
<td>DOB</td>
<td>DOJ</td>
<td>ADDRESS</td>
<td>CITY</td>
<td>PINCODE</td>
<td>MOBILE NO</td>
<td>STATE</td>
<td>EMAIL</td>
<td>PAN NUMBER</td>
<td>STATUS</td>
<td>DEPARTMENT NAME</td>
<td>GRADE NAME</td>

</tr>


<div id="empInfo">
<%String name=request.getParameter("empName");
EmployeeDaoImpl employDao=new EmployeeDaoImpl();

List<Employee> employeeList=employDao.searchEmployee(name);
for(int i=0;i<employeeList.size();i++)
{
	Employee employ=employeeList.get(i);
	%>
	<tr>
	<td><%=employ.getEmpId() %></td>
	<td><%=employ.getEmpName() %></td>
	<td><%=employ.getDob() %></td>
	<td><%=employ.getDoj() %></td>
	<td><%=employ.getAddress() %></td>
	<td><%=employ.getCity() %></td>
	<td><%=employ.getPincode() %></td>
	<td><%=employ.getMobileNo() %></td>
	<td><%=employ.getState() %></td>
	<td><%=employ.getMailId() %></td>
	<td><%=employ.getPanNo() %></td>
	<td><%=employ.getStatus() %></td>
	<td><%=employ.getDept().getDeptName() %></td>
	<td><%=employ.getGrade().getGradeName() %></td>
	</tr>
	
</div>
<%} %>
</table>
<center>
<br>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>
<input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
</center>
</body>
</html>