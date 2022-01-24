<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<style>

  body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/pexels-anna-nekrashevich-6801874.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    a{
    text-decoration: none;
    }
       
    label{
    width:200px;
    display:inline-block;
    }
      .formSty{
    background-color: white;
    border: 0px solid red;
  	padding: 0px 20px;
  	border-radius: 25px;
  	width:30%;
  	margin-left: 440px;
  	background-color: #a8acb7 ;
  	margin-top: 10%;
  	}
   

</style>
</head>
<body>
<form action="LeaveAdd" class="formSty"  >
<h2>ADD LEAVE</h2>
<label for="employId">EMPLOYEE ID</label>
<input type="number" name="empId" min="1" id="employId" pattern="[0-9]+" placeholder="enter employ ID"><br><br>

<label for="leaveDate">LEAVE DATE</label><br>
<input type="date" name="lDate" id="leaveDate" ><br><br>

<label for="leaveReason"> REASON</label>
<input type="text" name="reason" id="leaveReason" placeholder="enter leave reason"><br><br>
<center>
<input type="submit" class="btn btn-primary">
<input type="reset" class="btn btn-primary">

</form>

<button onclick="history.back()" class="btn btn-primary">BACK</button>

<a href="AdminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>

</center>
</body>
</html>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var yyyy1= today.getFullYear()-1;
maxdate =yyyy + '-' + mm + '-'+ dd  ;
mindate =yyyy1 + '-' + mm + '-'+ dd  ;
document.getElementById("leaveDate").setAttribute("max",maxdate);
document.getElementById("leaveDate").setAttribute("min",mindate);
}
</script>