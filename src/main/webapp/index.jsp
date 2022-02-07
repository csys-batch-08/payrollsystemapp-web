<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>
<meta name="keywords" content="payroll,salary management">
<title>payroll management</title>
<link rel="stylesheet" type="text/css" href="asset\css\index.css">
</head>
<body>
	

<div>
<img src="asset\images\pngegg (1).png" width="" height="" alt="payrollLogo">
	<div><h2>PAYROLL MANAGEMENT</h2></div>
	</div>
	<div class="container">
	
		<button type="button" class="btn btn-info btn-round"
			data-toggle="modal" data-target="#loginModal">Login</button>
	</div>
	<div id="excepSty">
		<c:set var="userError" scope="session" value="${invalid}" />
		<c:if test="${not empty userError}">
			<h2>
				<c:out value="${userError}" />
				&#9888;
			</h2>
			<c:remove var="userError"  scope="session"/>
		</c:if>
	</div>
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="wrapper">
					<div class="logo">
						<img src="asset\images\pngegg.png" alt="">
					</div>
					<div class="text-center mt-4 name">Payroll</div>
					<form class="p-3 mt-3" action="login" method="post">
						<div class="form-field d-flex align-items-center">
							<span class="far fa-user"></span>
							 <input type="email" aria-labelledby="userName"
								name="email"  required="required" id="userName"
								pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+" 
								placeholder="Email Id" autofocus="autofocus">
						</div>
						<div class="form-field d-flex align-items-center">
							<span class="fas fa-key"></span> 
							<input type="password"  aria-labelledby="pwd"
								name="pass" id="pwd"  required="required"
								onkeyup="checkpattern()" 
								pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,15}$"
								placeholder="*********" >
						</div>
						<div>
				<ul>
					<li id="upper">At least one upper case[A-Z]</li>
					<li id="lower">At least one lower case [a-z]</li>
					<li id="number">At least one number [0-9]</li>
					<li id="special">At least one special character [@$!%*?&]</li>
					<li id="char">At least 8 character</li>
				</ul>
			</div>
						<div class="checkBox">
							<input type="checkbox" onkeypress="myFunction()"  name="check"  aria-labelledby="pwdShow"> <label
								class="showPassword" for="pwdShow">Show Password</label>
						</div>
						
						<button class="btn mt-3">Login</button>
					</form>
					
				</div>
			</div>
		</div>
	</div>

<script>
	function myFunction() {
		var x = document.getElementById("pwd");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
	
	
	
	function checkpattern() {
		
		var password = document.getElementById("pwd").value;
		console.log(password)
		if (password.match(/(?=[A-Z])/)) {
			console.log("upper")
			document.getElementById("upper").style.color = "rgb(31, 224, 31)";
		} else {
			document.getElementById("upper").style.color = "black";
		}
		if (password.match(/(?=[a-z])/)) {
			console.log("lower")
			document.getElementById("lower").style.color = "rgb(31, 224, 31)";
		} else {
			document.getElementById("lower").style.color = "black";
		}
		if (password.match(/(?=[0-9])/)) {
			console.log("number")
			document.getElementById("number").style.color = "rgb(31, 224, 31)";
		} else {
			document.getElementById("number").style.color = "black";
		}
		if (password.match(/(?=.*[!@#\$%\^&\*])/)) {
			console.log("special")
			document.getElementById("special").style.color = "rgb(31, 224, 31)";
		} else {
			document.getElementById("special").style.color = "black";
		}
		if (password.length > 7) {
			console.log("character")
			document.getElementById("char").style.color = "rgb(31, 224, 31)";
		} else {
			document.getElementById("char").style.color = "black";
		}
	}
	
</script>
<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js'></script>
<script
	src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'></script>
</body>
</html>
