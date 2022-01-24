<%@page import="com.payroll.model.Departments"%>
<%@page import="com.payroll.dao.DepartmentsDaoImpl"%>
<%@page import="com.payroll.model.Employee"%>
<%@page import="java.util.List"%>
<%@page import="com.payroll.dao.EmployeeDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <title>payroll</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    

    <link rel="stylesheet" href="styles.css" />
    
    
    <style>
    
     body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("images/employ.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }
    label{
    width:200px;
    display:inline-block;
    margin-bottom: 21px;
    }
    .empDiv{
    text-align: center;
    }
     .formSty {
    background-color: white;
    border: 0px solid #ddbfbf;
    padding: 0px 0px;
    border-radius: 25px;
    width: 33%;
    margin-left: 440px;
    background-color: #ccd1d4;
}
   
    </style>
    
  </head>
  <body>
  
  <%String empAdd=(String)session.getAttribute("employInvalid");
  if(empAdd!=null){
	  %>
	  <h2><%=empAdd %></h2>
	  <%session.removeAttribute("employInvalid"); %>
  <%} %>
  
  
    <%String emp=(String)session.getAttribute("employalready");
  if(emp!=null){
	  %>
	  <h2><%=emp %></h2>
	  <%session.removeAttribute("employalready"); %>
  <%} %>
  
      <%String grdDept=(String)session.getAttribute("gradeDept");
  if(grdDept!=null){
	  %>
	  <h2><%=grdDept %></h2>
	  <%session.removeAttribute("gradeDept"); %>
  <%} %>
  
  
  <div class="empDiv">
 
  <h3>ADD EMPLOYEE </h3>
  

<form action="empAdd" class="formSty" method="post" >
<br>
<div>
<table>
<tr>
<td><label for="name">NAME</label></td>
<td><input type="text" pattern="[a-zA-z\s]+" id="name" name="EmployeeName" placeholder="Enter your name" autofocus="autofocus"><br><br></td>
</tr>
<tr>
<td>
<label for="dob" >DATE OF BIRTH</label>
</td>
<td>
<input type="date" pattern="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}" id="dob" name="dob" placeholder="enter your DOB"><br><br>
</td>
</tr>
<tr>
<td>
<label for="doj">DATE OF JOINING</label>
</td>
<td>
<input type="date" pattern="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}" id="doj" name="doj" placeholder="Date Of Joining"><br><br>
</td>
</tr>
<tr>
<td>
<label for="address">ADDRESS</label>
</td>
<td>
<input type="text" pattern="[a-zA-z0-9/,\s]+" id="address" name="address" placeholder="Enter Address"><br><br>
</td>
</tr>
<tr>
<td>
<label for="city">CITY</label>
</td>
<td>
<input type="text" pattern="[a-zA-z\s]+" id="city" name="city" placeholder="Enter city"><br><br>
</td>
</tr>
<tr>
<td>
<label for="pincode">PINCODE</label>
</td>
<td>
<input type="number"  maxlength="6" id="pincode" name="pincode" placeholder="pincode"><br><br>
</td>
</tr>
<tr>
<td>
<label for="mobileno">MOBILE NUMBER</label>
</td>
<td>
<input type="number" pattern="[0-9]{10}" id="mobileno" maxlength="10"  name="mobileNumber" placeholder="Enter MobileNumber"><br><br>
</td>
</tr>
<tr>
<td>
<label for="state">STATE</label>
</td>
<td>
<input type="text" pattern="[a-zA-z\s]+" id="state" name="state" placeholder="Enter State"><br><br>
</td>
</tr>
<tr>
<td>
<label for="mailId">EMAIL ID</label>
</td>
<td>
<input type="email" pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+" id="mailId" name="mailId" placeholder="Enter employ mail"><br><br>
</td>
</tr>
<tr>
<td>
<label for="panNumber">PAN NUMBER</label>
</td>
<td>
<input type="text" pattern="[a-zA-z0-9]+{10}" maxlength="10" id="panNumber" name="panNo" placeholder="Enter Pan Number"><br><br>
</td>
</tr>
<tr>
<td>
<label for="departName">DEPARTMENT NAME</label>
</td>
<td>
<input type="text"  pattern="[a-zA-Z\s]+" name="deptName" placeholder="Enter Department Name"><br><br>
</td>
</tr>
<tr>
<td>
<label for="gradeName">GRADE NAME</label>
</td>
<td>
<input type="text"  pattern="[a-zA-Z\s]+" name="grdName" placeholder="Enter grade Name"><br><br>
</td>
</tr>

</table>
</div>




<center>
<button type="submit" class="btn btn-primary">Submit</button>

<input type="reset" class="btn btn-primary">

</form>
<a href="AdminControl.jsp" ><button type="button" class="btn btn-primary"><strong>HOME</strong></button></a>
<input type="button" value="Go back!" onclick="history.go(-1)" class="btn btn-primary">
<br><br>
</center>
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
    var yyyy1= today.getFullYear()-24;
maxdate =yyyy1 + '-' + mm + '-'+ dd  ;

document.getElementById("dob").setAttribute("max",maxdate);

}
</script>
<script>
today();
function today(){
    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    var yyyy1= today.getFullYear()-10;
maxdate =yyyy + '-' + mm + '-'+ dd  ;
mindate =yyyy1 + '-' + mm + '-'+ dd  ;
document.getElementById("doj").setAttribute("max",maxdate);
document.getElementById("doj").setAttribute("min",mindate);
}
</script>