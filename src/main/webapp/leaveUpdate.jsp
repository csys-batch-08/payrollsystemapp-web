
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>payroll</title>
  <link rel="stylesheet" type="text/css" href="asset\css\leaveUpdate.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 
</head>
<body>
<c:forEach items="${sessionScope.leave}" var="leaveUpd">

<form action="leaveUpd" class="formSty" method="post">
<center>
<label for="leaveDt">LEAVE DATE</label>
<input type="date" id="leaveDt"  name="leaveDate" value="${leaveUpd.leaveDt }"><br><br>
<label for="leaveRs">REASON</label>
<input type="text" id="leaveRs"  name="reason" value="${leaveUpd.LeaveReason }"><br><br>
<input type="submit" class="btn btn-primary">

</form>
</c:forEach>
<button onclick="history.go(-1)" class="btn btn-primary">GO BACK</button>
<a href="adminControl.jsp"><button type="button" class="btn btn-primary">HOME</button></a>

</center>
</body>
</html>