<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>admin Control</title>
<link rel="stylesheet" type="text/css" href="asset\css\adminControl.css">


</head>
<body>
<marquee width="100%" direction="LEFT" height="100px" scrollamount="10" > 
<h1 style="color:rgb(240, 240, 240);" >
ADMIN CONTROLS
</h1>
</marquee>


<div class="navbar">
<div class="dropdown" >
<button class="dropbtn">
&#9776EMPLOYEE 
</button>
<div class="dropdown-content" id="downNav">
<a href="ShowEmployee">Show Active Employ</a>
<a href="employeeAdd.jsp">ADD Employee </a>
<a href="ShowInactiveEmploy">Show In-Active Employ</a>
</div>
</div>

<div class="dropdown" >
<button class="dropbtn" >
&#9776DEPARTMENT
</button>
<div class="dropdown-content" id="downNav">
<a href="departmentAdd.jsp">ADD Department </a>
<a href="showDept">Department Show</a>
<a href="ShowInactiveDepart">Show In-Active Employ</a>
</div>
</div>


<div class="dropdown" >
<button class="dropbtn">
&#9776GRADE
</button>
<div class="dropdown-content" id="downNav">
<a href="gradeAdd.jsp">ADD Grade</a>
<a href="GradeShow">Grade Show</a>
</div>
</div>

<div class="dropdown" >
<button class="dropbtn">
&#9776LEAVE DETAIL
</button>
<div class="dropdown-content" id="downNav">
<a href="leaveAdd.jsp">ADD Leave</a>
<a href="LeaveShow">Leave Show</a>
</div>
</div>

<div class="dropdown" >
<button class="dropbtn">
&#9776SALARY
</button>
<div class="dropdown-content" id="downNav">
<a href="salaryAdd.jsp">Enter Salary Detail</a>
<a href="salaryEmployee.jsp">Salary Report</a>
<a href="ShowSalaryEmpl">Show Salary Detail</a>
</div>
</div>


<div class="dropdown" style="float:right">
<a href="index.jsp">
<button class="dropbtn">&#9776>LOGOUT</button></a>
</div>
</div>
</body>
</html>
