<%@page import="com.payroll.dao.LeaveDaoImpl"%>
<%@page import="com.payroll.dao.GradeDaoImpl"%>
<%@page import="com.payroll.dao.DepartmentsDaoImpl"%>
<%@page import="com.payroll.model.EmpSalary"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.SalaryCalculateDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show SalaryEmploy</title>
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

tr:nth-child(even) {
background-color: #f2f2f2;
}
a{
text-decoration:none;
}
#search{
float: right;
margin-top:10px;
margin-right: 40px;
}

.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

#main {
  transition: margin-left .5s;
  padding: 16px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}
#sideNav{
margin-left: 10px;
}
    </style>
</head>
<body>
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="TotalSalary.jsp">Salary Count</a>
  <a href="SalaryInDate.jsp">Salary In-between</a>
  
</div>
<div id="main">
 <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; SALARY</span>

<table>
<tr class="bg-primary">
<td>EMPLOYEE ID</td>
<td>DEPARTMENT NAME</td>
<td>GRADE NAME</td>
<td>TOTAL LEAVE</td>
<td>SALARY DATE</td>
<td>GROSS SALARY</td>
<td>ACTUAL SALARY</td>
<td>DELETE</td>
</tr>

<%SalaryCalculateDaoImpl salaryCal=new SalaryCalculateDaoImpl();
List<EmpSalary> SalaryEmploy=salaryCal.showEmployee();
for(int i=0;i<SalaryEmploy.size();i++){
	EmpSalary salary=SalaryEmploy.get(i);
	LeaveDaoImpl leaveDao=new LeaveDaoImpl();
	int leave=leaveDao.leaveDays(salary.getEmp().getEmpId());
	%>

<tr>
<td><%=salary.getEmp().getEmpId() %></td>
<td><%=salary.getDept().getDeptName() %></td>
<td><%=salary.getGrade().getGradeName() %></td>
<td><%=leave %></td>
<td><%=salary.getSalaryDate() %></td>
<td><%=salary.getGross() %></td>
<td><%=salary.getSalary() %></td>
<td><a href="salDel?salId=<%=salary.getTransId() %>">DELETE</a></td>
</tr>
<%} %>
</table>
</div>
<center>
<br>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>Home Page</strong></button></a>
<input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
</center>

</body>
</html>
<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
  document.getElementById("main").style.marginLeft = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
  document.getElementById("main").style.marginLeft= "0";
}
</script>