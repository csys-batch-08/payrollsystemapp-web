<%@page import="java.util.List"%>
<%@page import="com.payroll.model.Grade"%>
<%@page import="com.payroll.dao.GradeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
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
     background-image: url("images/tyler-franta-iusJ25iYu1c-unsplash.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    label{
    width:200px;
    display:inline-block;
    }
     .formSty{
    background-color: white;
  	padding: 0px 20px;
  	border-radius: 25px;
  	width:30%;
  	margin-left: 440px;
  	background-color: #a7bce3 ;
  	margin-top:10%;
  	}

</style>
</head>
<body>
<% String negative=(String)session.getAttribute("negativeValue");
if(negative!=null) {
%>
<h2><%=negative %></h2>
<%session.removeAttribute("negativeValue"); %>
<%} %>



<%int gradeId=Integer.parseInt(request.getParameter("gradeId"));
session.setAttribute("gradeId", gradeId);
GradeDaoImpl gradeDao=new GradeDaoImpl();
Grade grade=gradeDao.findGrade(gradeId);

%>

<form action="gradeUpd" class="formSty" >
<br>


<label for="gradeBasic">BASIC SALARY</label>
<input type="number" id="gradeBasic" min="1" name="basic" value="<%=grade.getGradeBasic()%>"><br><br>

 <label for="gradeBonus">BONUS SALARY</label>
<input type="number" id="gradeBonus" min="1" name="bonus" value="<%=grade.getGradeBonus()%>" ><br><br>

 <label for="gradePf">PROVIDENT FUND</label>
<input type="number" id="gradePf" min="1" name="pf" value="<%=grade.getGradePf()%>"><br><br>

 <label for="gradePt">PROFESSIONAL TAX</label>
<input type="number" id="gradePt" min="1" name="pt" value="<%=grade.getGradePt() %>" ><br><br>

<center>
<input type="submit" class="btn btn-primary">
<input type="reset" class="btn btn-primary">

</form>
<button onclick="history.back()" class="btn btn-primary">BACK</button>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>

</center>
</body>
</html>