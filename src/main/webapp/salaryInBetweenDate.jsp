
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Salary Inbetween Date</title>
  <link rel="stylesheet" type="text/css" href="asset\css\salaryInBetweenDate.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
	<div class="salDate">
		<table>
			<tr>
				<th scope="col"><label for="salFrom">FROM DATE</label></th>
				<td><input type="date" id="salFrom" name="salfromDt"></td>
			</tr>
			<tr>
				<th scope="col"><label for="salTo">TODATE</label></th>
				<td><input type="date" id="salTo" name="saltoDate"
					onchange="totalAmount()"></td>

			</tr>
			<tr>
				<th scope="col"><label for="salTotal">TOTAL AMOUNT</label></th>
				<td><input id="salTotal" name="totalSal" value=""></td>
			</tr>
			<tr>
				<th scope="col"><button onclick="history.go(-1)" class="btn btn-primary">GO
						BACK</button></th>
				<th scope="col"><a href="adminControl.jsp"><button type="button"
							class="btn btn-primary">HOME</button></a></th>
			</tr>
		</table>
	</div>
	<script>
	function totalAmount() {
		var fromSal = document.getElementById("salFrom").value;
		var toSal = document.getElementById("salTo").value;
		console.log(fromSal + "fromSal" + toSal + "toSalaryDt");

		var url = 'totalAmount?fromSal=' + fromSal + '&toSal=' + toSal;

		if (window.XMLHttpRequest) {
			request = new XMLHttpRequest();
		} else if (window.ActiveXObject) {
			request = new ActiveXObject("Microsoft.XMLHTTP");
		}
		try {
			request.onreadystatechange = getInfo;
			request.open("GET", url, true);
			request.send();
		} catch (e) {
			alert("Unable to connect to server");
		}
	}

	function getInfo() {
		if (request.readyState == 4) {
			var val = request.responseText;
			document.getElementById("salTotal").value = val.trim();
		}
	}
</script>
	
</body>
</html>
