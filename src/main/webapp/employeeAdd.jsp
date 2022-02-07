<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>employee add</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<link rel="stylesheet" type="text/css" href="asset/css/employeeAdd.css">

</head>
<body>

	<div id="employAdd">
		<c:set var="empAdd" scope="session" value="${employInvalid}" />
		<c:if test="${not empty empAdd}">
			<h2>
				<c:out value="${empAdd}U+26A0" />
				&#9888;
			</h2>
			<c:remove var="empAdd" scope="session" />
		</c:if>



		<c:set var="emp" scope="session" value="${employalready}" />
		<c:if test="${not empty emp}">
			<h2>
				<c:out value="${emp}" />
				&#9888;
			</h2>
			<c:remove var="emp" scope="session" />
		</c:if>

		<c:set var="grdDept" scope="session" value="${gradeDept}" />
		<c:if test="${not empty grdDept}">
			<h2>
				<c:out value="${grdDept}" />
				&#9888;
			</h2>
			<c:remove var="grdDept" scope="session" />
		</c:if>
	</div>
		<fmt:bundle basename = "com.payroll.bundle.Label" prefix="nav.">

	<div class="empDiv">

		<h3>ADD EMPLOYEE</h3>


		<form action="empAdd" class="formSty" method="post">
			<br>
			<div>
				<table>
					<tr>
						<td><label for="name">NAME <span>*</span></label></td>
						<td><input type="text" pattern="[a-zA-Z\s]{3,30}+" id="name"
							name="EmployeeName" placeholder="Enter Employee Name"
							title="minimum 3 characters and accept only alphabets"
							autofocus="autofocus" required="required"><br> <br></td>
					</tr>
					<tr>
						<td><label for="dob">DATE OF BIRTH<span>*</span></label></td>
						<td><input type="date"
							pattern="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"
							id="dob" name="dob" placeholder="enter your DOB"
							required="required"><br> <br></td>
					</tr>
					<tr>
						<td><label for="doj">DATE OF JOINING<span>*</span></label></td>
						<td><input type="date"
							pattern="(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[012])[-]\\d{4}"
							id="doj" name="doj" placeholder="Date Of Joining"
							required="required"><br> <br></td>
					</tr>
					<tr>
						<td><label for="address"><fmt:message  key="Address"/><span>*</span></label></td>
						<td><input type="text" pattern="^[#.0-9a-zA-Z\s,-]+$"
							id="address" name="address" placeholder="Enter Address"
							required="required"><br> <br></td>
					</tr>
					<tr>
						<td><label for="city"><fmt:message  key="City"/><span>*</span></label></td>
						<td><input type="text" id="city" 
							pattern="^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$"
							name="city" placeholder="Enter city"
							required="required"><br> <br></td>
					</tr>
					<tr>
						<td><label for="pincode"><fmt:message  key="Pincode"/><span>*</span></label></td>
						<td><input type="number" maxlength="6" id="pincode"
							pattern="([1-9]{1}[0-9]{5}|[1-9]{1}[0-9]{3}\\s[0-9]{3})"
							name="pincode" placeholder="pincode" required="required"><br>
							<br></td>
					</tr>
					<tr>
						<td><label for="mobileno">MOBILE NUMBER<span>*</span></label></td>
						<td><input type="number"
							pattern="/^(\+\d{1,3}[- ]?)?\d{10}$/" id="mobileno"
							maxlength="10" name="mobileNumber"
							placeholder="Enter MobileNumber" required="required"><br>
							<br></td>
					</tr>
					<tr>
						<td><label for="state"><fmt:message  key="State"/><span>*</span></label></td>
						<td><input type="text"
							pattern="[a - zA - Z] + |[a - zA - Z] + \\s[a - zA - Z] + )"
							id="state" name="state" placeholder="Enter State"
							required="required"><br> <br></td>
					</tr>
					<tr>
						<td><label for="mailId">EMAIL ID<span>*</span></label></td>
						<td><input type="email" onchange="validateEmail()"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" id="mailId"
							name="mailId" placeholder="Enter employ mail" required="required"><br>
							<br></td>
					</tr>
					<tr>
						<td><label for="panNumber">PAN NUMBER<span>*</span></label></td>
						<td><input type="text" onchange="panNoValid()"
							pattern="[a-zA-z0-9]+{10}" maxlength="10" id="panNumber"
							name="panNo" placeholder="Enter Pan Number" required="required"><br>
							<br></td>
					</tr>
					<tr>
						<td><label for="departName">DEPARTMENT NAME<span>*</span></label></td>
						<td><input type="text" id="departName"
							onchange="deptNameValid()" pattern="[a-zA-Z\s]+" name="deptName"
							placeholder="Enter Department Name" required="required"><br>
							<br></td>
					</tr>
					<tr>
						<td><label for="gradeName">GRADE NAME<span>*</span></label></td>
						<td><input type="text" pattern="[a-zA-Z\s]+"
							onchange="grdNameValid()" id="gradeName" name="grdName"
							placeholder="Enter grade Name" required="required"><br>
							<br></td>
					</tr>

				</table>
			</div>




			<div>
				<button type="submit" class="btn btn-primary"><fmt:message  key="Submit"/></button>

				<input type="reset"  class="btn btn-primary">
				</div>
				
		</form>
		<div>
		<a href="adminControl.jsp"><button type="button"
				class="btn btn-primary">
				<strong><fmt:message  key="Home"/></strong>
			</button></a> <input type="button" value="Go back!" onclick="history.go(-1)"
			class="btn btn-primary"> <br> <br>
		</div>
	</div>
			</fmt:bundle>
	
	<script>
		today();
		function today() {
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();
			var yyyy1 = today.getFullYear() - 22;
			maxdate = yyyy1 + '-' + mm + '-' + dd;

			document.getElementById("dob").setAttribute("max", maxdate);

		}
	</script>
	<script>
		today();
		function today() {
			var today = new Date();
			var dd = String(today.getDate()).padStart(2, '0');
			var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
			var yyyy = today.getFullYear();
			var yyyy1 = today.getFullYear() - 10;
			maxdate = yyyy + '-' + mm + '-' + dd;
			mindate = yyyy1 + '-' + mm + '-' + dd;
			document.getElementById("doj").setAttribute("max", maxdate);
			document.getElementById("doj").setAttribute("min", mindate);
		}

		function validateEmail() {
			let email = document.getElementById("mailId").value;
			var url = 'emailValidate?email=' + email;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				request.onreadystatechange = getInfoEmail;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}

		}
		function getInfoEmail() {
			if (request.readyState == 4) {
				var val = request.responseText;
				if (val.includes("This Email Already Available")) {
					alert(val);
					document.getElementById("mailId").value = "";

				}

			}
		}
		function panNoValid() {
			let panNo = document.getElementById("panNumber").value;
			var url = 'panNoValidate?panNo=' + panNo;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				request.onreadystatechange = getInfoPanNo;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}

		}
		function getInfoPanNo() {
			if (request.readyState == 4) {
				var val = request.responseText;
				if (val.includes("This PanNumber Already Available")) {
					alert(val);
					document.getElementById("panNumber").value = "";

				}

			}
		}
		/* department name validate */
		function deptNameValid() {
			let deptName = document.getElementById("departName").value;
			var url = 'deptNameValidate?deptName=' + deptName;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				request.onreadystatechange = getInfoDeptName;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}

		}
		function getInfoDeptName() {
			if (request.readyState == 4) {
				var val = request.responseText;
				if (val.includes("This Department Name Not Found")) {
					alert(val);
					document.getElementById("departName").value = "";

				}

			}
		}

		/* grade Name validate */
		function grdNameValid() {
			let grdName = document.getElementById("gradeName").value;
			var url = 'GrdNameValidate?grdName=' + grdName;
			if (window.XMLHttpRequest) {
				request = new XMLHttpRequest();
			} else if (window.ActiveXObject) {
				request = new ActiveXObject("Microsoft.XMLHTTP");
			}
			try {
				request.onreadystatechange = getInfogrdName;
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}

		}
		function getInfogrdName() {
			if (request.readyState == 4) {
				var val = request.responseText;
				if (val.includes("This Grade Name Not Found")) {
					alert(val);
					document.getElementById("gradeName").value = "";

				}

			}
		}
	</script>
</body>

</html>
