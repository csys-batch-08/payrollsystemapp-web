<%@page import="com.payroll.model.Departments"%>
<%@page import="com.payroll.model.Employee"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salary Approve</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
    body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/pexels-anna-nekrashevich-6801874.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    label{
    width:200px;
    display:inline-block;
    }
     .style{
    background-color: white;
  	padding: 0px 20px;
  	border-radius: 25px;
  	width:30%;
  	margin-left: 440px;
  	background-color: #b1c3e7 ;
  	margin-top:10%;
  	}
  	

</style>
</head>
<body>
<%int empId=Integer.parseInt(request.getParameter("eId"));
		EmployeeDaoImpl employDao=new EmployeeDaoImpl();
		Employee employ=employDao.findEmployee(empId);
		Departments department=employ.getDept();
		String departName=department.getDeptName();
		String grdName=employ.getGrade().getGradeName();%>
<form action="salaryInsert" class="style">
<div id="salsty">
<br>

		
		<label for="gradeName">EMPLOYEE ID</label>
		
		<input type="text" name="empId" value="<%=empId%>"><br><br>
<label for="gradeName">GRADE NAME</label>
<input type="text" name="gName" id="gradeName"  value="<%=grdName%>"><br><br>
<label for="deptName">DEPARTMENT NAME</label>
<input type="text" name="dName" id="deptName" value="<%=departName%>"><br><br>


<label for="taxDeducte">PROFESSIONAL TAX</label>

<select name="tax" id="pf">
  <option value="yes">Yes</option>
  <option value="no">No</option>
 
</select>

<br><br>
<label for="monthBonus">MONTH BONUS</label>

<select name="bonus" id="monthBonus">
  <option value="yes">Yes</option>
  <option value="no">No</option>
 
</select>
<br>
<br>
<input type="reset" class="btn btn-primary">
<button type="submit" class="btn btn-primary">Submit</button>


</form>
<button onclick="history.back()" class="btn btn-primary">BACK</button>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>
<br><br>
</div>
</body>
</html>