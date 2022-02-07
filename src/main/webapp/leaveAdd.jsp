<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
  <link rel="stylesheet" type="text/css" href="asset\css\leaveAdd.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>


<body>
<form action="LeaveAdd" class="formSty"  method="post">
<h2>ADD LEAVE</h2>
<label for="employId">EMPLOYEE ID</label>
<input type="number" name="empId" min="1" id="employId" pattern="[0-9]+" placeholder="enter employ ID"><br><br>

<label for="leaveDate">LEAVE DATE</label><br>
<input type="date" name="lDate" id="leaveDate" ><br><br>

<label for="leaveReason"> REASON</label>
<input type="text" name="reason" id="leaveReason" placeholder="enter leave reason"><br><br>
<div>
<input type="submit" class="btn btn-primary">
<input type="reset"  class="btn btn-primary" name="rest"  aria-labelledby="rest"/>
</div>
</form>
<div>
<button onclick="history.back()" class="btn btn-primary">BACK</button>

<a href="adminControl.jsp"><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>

</div>
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