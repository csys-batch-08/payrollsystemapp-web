<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>

<title>Payroll</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("images/tezos-O5fxEDu0S5I-unsplash.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}

.big-btn { `
	
	position: absolute;
	top: 50%;
	left: 50%;
	 background-color: rgb(120, 120, 120);
	border: 1px solid ;
	color: black;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	font-size: 16px;
	cursor: pointer;
	display: block;
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	border-radius: 12px;
		
}

.big-btn:hover {
	background-color: #9AB2A4;
}

a {
	text-decoration: none;
}
input{
height: 25px; width : 200px;
}
#imgSty img{
height: 75px;
width:100px;

}
.pageAlign{
 
    padding: 11Spx;
    border-radius: 6px;
    width:25%;
}
#headpayroll{
position:absolute;
margin-left:110px;
margin-top:-50px;
color:#F7DC6F;
text-shadow: 2px 2px red;
}
#welcomeform{
margin-top:300px;
}
#loginform{
margin-top:300px;

}
.checkBox {
position: relative;
left:-30px;
}
.checkBox input{
height: 20px;
width:20px;
}
.showPassword{
position: relative;
left:12px;
top:-4px;

}
.submitBtn{
position: relative;
top: 10px;
}


</style>
</head>
<body>
<c:set var = "userError" scope = "session" value = "${invalid}"/>
	<font color="#F7DC6F"> 
	<c:if test="${not empty userError}">
			<h2><c:out value="${userError}" /></h2>
		</c:if></font>

	<div id="imgSty">
	<img alt="" src="images/pngegg (1).png">
</div>


	<center>
	<h1 id="headpayroll" >PAYROLL MANAGEMENT</h1>
		&nbsp;
		<div id="welcomeform" style="display: block;" >
		
			<h1 style="color:#7D3C98  " >
				<STRONG>ADMINISTRATOR &nbsp; </STRONG>
			</h1>
			
			<button class="big-btn" style="width: 10%; font-size: 20px;"
				 onclick="showform()">
				<strong>Login</strong>
			</button>
		</div>


		<script type="text/javascript">
			function showform() {
				var welcomeform = document.getElementById("welcomeform");
				welcomeform.style.display = "none";
				var loginform = document.getElementById("loginform");
				loginform.style.display = "block";
			}
		</script>
		
		<div id="loginform" style="display: none;">
			<form action="login" method="post">

				<div class="pageAlign">

					<label for="mailId" style="color: #FDFEFE ;"><strong>EMAIL ID </strong></label><br> <input type="email"
						id="mailId" name="email" required placeholder="example@gmail.com"
						pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+" style="border-radius: 10px;"  autofocus>
							&nbsp;&nbsp;<br><br> 
							
							<label for="password" style="color:#FDFEFE ;"><strong>PASSWORD</strong> </label> <br>
					<input type="password" id="password" name="pass" style="border-radius: 10px;left: 50%;right:50%;" required placeholder="*********"
						pattern="[A-Za-z0-9@#.!&]{8,16}">
					&nbsp;	
					<div class="checkBox">
					<input type="checkbox" onclick="myFunction()">
					<label class="showPassword">Show Password</label> 
					</div>
					<button  style="border-radius: 8px;" type="submit" class="submitBtn" >submit</button>
					<br>
					<br>
				</div>
			</form>


		</div>
	</center>
</body>
</html>
<script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}
</script>