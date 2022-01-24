<%@page import="com.payroll.model.Departments"%>
<%@page import="com.payroll.dao.DepartmentsDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
 body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/thought-catalog-505eectW54k-unsplash.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    
    label{
    width:200px;
    display:inline-block;
    }
    .formSty {
    background-color: white;
    padding: 0px 20px;
    border-radius: 25px;
    width: 30%;
    margin-top: 3%;
    margin-left: 650px;
    background-color: #c8c9c2;
}
    </style>
</head>
<body>
<%String deptUpd=(String)request.getParameter("deptUpdData");
if(deptUpd!=null){
%>
<h3><%=deptUpd %></h3>
<%session.removeAttribute("deptUpdData"); %>
<%} %>
<center>
<%int deptId=Integer.parseInt(request.getParameter("departId"));
session.setAttribute("editDeptId", deptId);
DepartmentsDaoImpl departDao=new DepartmentsDaoImpl();
Departments department=departDao.findDepartment(deptId);
%>
<form action="deptUpd" method="get" >
<br><br>
<div class="formSty">
<br>
<label for="deptName">DEPARTMENT NAME</label>
<input type="text" id="deptName" name="name" autofocus="autofocus" value="<%=department.getDeptName() %>"><br><br>
<input type="submit"class="btn btn-primary">

</form>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary">HOME</button></a>

 <button onclick="history.go(-1)" class="btn btn-primary">GO BACK</button></center>

</center>
</body>
</html>
