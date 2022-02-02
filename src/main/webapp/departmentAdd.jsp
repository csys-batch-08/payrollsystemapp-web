<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Add</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("asset/images/pexels-anna-nekrashevich-6801874.jpg");
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
    margin-top: 5%;
    background-color: #b3bac2;
    margin-left: -684px;
	}
  	</style>
</head>
<body>
<c:set var = "deptError" scope = "session" value = "${departAlready}"/>
	<c:if test="${not empty deptError}">
			<h2><c:out value="${deptError}" /></h2>
			<c:remove var="deptError"/>
		</c:if>

<center>

<form action="deptAdd"  method="post" >
<br><br>
<div class="formSty">
<br>
<label for="deptName">DEPARTMENT NAME</label>
<input type="text" id="deptName" name="dptname" autofocus="autofocus" ><br><br>
<input type="submit" class="btn btn-primary">
<input type="reset" class="btn btn-primary">
<a href="adminControl.jsp"><button type="button" class="btn btn-primary">HOME</button></a>

<br>
</div>
</form>

</center>

</body>
</html>