<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.payroll.dao.SalaryCalculateDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salary Inbetween Date</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/pexels-anna-nekrashevich-6801874.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    .salDate {
    background-color: white;
    padding: 15px 22px;
    border-radius: 25px;
    width: 30%;
    background-color: #a7bce3;
    margin-top: 5%;
    margin-left: 54px;
    }
    
</style>
</head>
<body>
<div class="salDate">
<table>
<tr>
<td>
<label for="salFrom">FROM DATE</label>
</td>
<td>
<input type="date" id="salFrom" name="salfromDt">
</td>
</tr>
<tr>
<td>
<label for="salTo">TODATE</label>
</td>
<td>
<input type="date" id="salTo" name="saltoDate" onchange="totalAmount()">
</td>

</tr>
<tr>
<td>
<label for="salTotal">TOTAL AMOUNT</label>
</td>
<td>
<input id="salTotal" name="totalSal" value="">

</td>
</tr>
<tr>
<td><button onclick="history.go(-1)" class="btn btn-primary">GO BACK</button></td>
<td>
<a href="AdminControl.jsp"><button type="button" class="btn btn-primary">HOME</button></a></td>
</tr>
</table>
</div>
</body>
</html>
<script>
function totalAmount(){     
    var fromSal =document.getElementById("salFrom").value;
    var toSal=document.getElementById("salTo").value;
    console.log(fromSal+"fromSal"+toSal+"toSalaryDt");
    
	var url='totalAmount.jsp?fromSal='+fromSal+'&toSal='+toSal;  
	
	if(window.XMLHttpRequest){  
		request=new XMLHttpRequest();  
		}  
		else if(window.ActiveXObject){  
		request=new ActiveXObject("Microsoft.XMLHTTP");  
		}  
	try  
	{  
	request.onreadystatechange=getInfo;  
	request.open("GET",url,true);  
	request.send();  
	}  
	catch(e)  
	{  
	alert("Unable to connect to server");  
	}
    }
   
 

function getInfo(){  
	if(request.readyState==4){  
	var val=request.responseText;
	document.getElementById("salTotal").value=val.trim();
	}  
	}


</script>
