<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>
<title>Insert title here</title>
<style>
.container {
	padding: 2rem 0rem;
}
.btn:not(:disabled):not(.disabled) {
    height: 60px;
    cursor: pointer;
    width: 106px;
    border-radius: 15px;
}
.btn btn-info btn-round{
border-radius: 14px;
    height: 50px;
    cursor: pointer;
    width: 100px;
}

@media ( min-width : 576px) {
	.modal-dialog {
		max-width: 400px;
	}
	.modal-dialog .modal-content {
		padding: 1rem;
	}
}

.modal-header .close {
	margin-top: -1.5rem;
}

@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif
}

  body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("asset/images/tezos-O5fxEDu0S5I-unsplash.jpg");
    background-repeat: no-repeat;
	background-size: cover;
    }

.wrapper {
	max-width: 350px;
	min-height: 500px;
	margin: 80px auto;
	padding: 40px 30px 30px 30px;
	background-color: #ecf0f3;
	border-radius: 15px;
	box-shadow: 13px 13px 20px #cbced1, -13px -13px 20px #fff
}

.logo {
	width: 80px;
	margin: auto
}

.logo img {
	width: 100%;
	height: 80px;
	object-fit: cover;
	border-radius: 50%;
	box-shadow: 0px 0px 3px #5f5f5f, 0px 0px 0px 5px #ecf0f3, 8px 8px 15px
		#a7aaa7, -8px -8px 15px #fff
}

.wrapper .name {
	font-weight: 600;
	font-size: 1.4rem;
	letter-spacing: 1.3px;
	padding-left: 10px;
	color: #555
}

.wrapper .form-field input {
	width: 100%;
	display: block;
	border: none;
	outline: none;
	background: none;
	font-size: 1.2rem;
	color: #666;
	padding: 10px 15px 10px 10px
}

.wrapper .form-field {
	padding-left: 10px;
	margin-bottom: 20px;
	border-radius: 20px;
	box-shadow: inset 8px 8px 8px #cbced1, inset -8px -8px 8px #fff
}

.wrapper .form-field .fas {
	color: #555
}

.wrapper .btn {
	box-shadow: none;
	width: 100%;
	height: 40px;
	background-color: #03A9F4;
	color: #fff;
	border-radius: 25px;
	box-shadow: 3px 3px 3px #b1b1b1, -3px -3px 3px #fff;
	letter-spacing: 1.3px
}

.wrapper .btn:hover {
	background-color: #039BE5
}

.wrapper a {
	text-decoration: none;
	font-size: 0.8rem;
	color: #03A9F4
}

.wrapper a:hover {
	color: #039BE5
}

@media ( max-width : 380px) {
	.wrapper {
		margin: 30px 20px;
		padding: 40px 15px 15px 15px
	}
}
.container {
    margin-top: 29%;
    padding: 2rem 0rem;
    margin-left: 49%;
}
#excepSty{
color:red;
}
</style>
</head>
<body>
<div id="excepSty">
	<c:set var="userError" scope="session" value="${invalid}" />
	 <c:if test="${not empty userError}">
			<h2>
				<c:out value="${userError}" />
				&#9888;
			</h2>
			<c:remove var="userError" />
		</c:if></div>
		
	<div class="container">
		<button type="button" class="btn btn-info btn-round"
			data-toggle="modal" data-target="#loginModal">Login</button>
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
							<span class="far fa-user"></span> <input type="email"
								name="email" required="required" id="userName" pattern="[a-z][a-z0-9]+[@][a-z]+[.][a-z]+"
								placeholder="Email Id" autofocus="autofocus">
						</div>
						<div class="form-field d-flex align-items-center">
							<span class="fas fa-key"></span> <input type="password"
								name="pass" id="password" pattern="[A-Za-z0-9@#.!&]{8,16}"
								 placeholder="*********">
						</div>
						<div class="checkBox">
					<input type="checkbox" onclick="myFunction()"> <label
						class="showPassword">Show Password</label>
				</div>
						<button class="btn mt-3">Login</button>
					</form>
					<div class="text-center fs-6">
						<a href="#">Forget password?</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
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
<!-- jQuery -->
<script src='https://code.jquery.com/jquery-3.3.1.slim.min.js'></script>
<!-- Popper JS -->
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js'></script>
<!-- Bootstrap JS -->
<script
	src='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js'></script>