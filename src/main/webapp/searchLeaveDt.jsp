<%@page import="java.time.LocalDate"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.Date"%>
<%@page import="com.payroll.model.Leave"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.LeaveDaoImpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Leave Date</title>
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
</style>
</head>
<body>
<h2>BETWEEN LEAVE DATE</h2>
<%
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
Date fromDt=null;
Date toDate=null;
try{
	 toDate=sdf.parse(request.getParameter("toDate"));

	 fromDt =sdf.parse(request.getParameter("fromDt"));
}
catch(Exception e){
	e.getStackTrace();
}


LeaveDaoImpl leaveDao=new LeaveDaoImpl();
List<Leave> leaveList=leaveDao.searchLeave(fromDt, toDate); %>
<table>

<tr class="bg-primary">
<td>LEAVE ID</td>
<td>EMPLOYEE ID</td>
<td>LEAVE DATE</td>
<td>REASON</td>
</tr>

<%

for(int i=0;i<leaveList.size();i++){
	Leave leave=leaveList.get(i);
	%>
	<tr>
	<td><%=leave.getLeaveId() %></td>
	<td><%=leave.getEmploy().getEmpId() %></td>
	<td><%=leave.getLeaveDt() %></td>
	<td><%=leave.getLeaveReason() %></td>
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