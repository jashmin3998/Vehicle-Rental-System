<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel='icon' href='/images/favicon.ico' type='image/x-icon'/>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Admin Update Vendor</title>
</head>
<body>
<script type="text/javascript">
				function validate() {
					var pass = document.getElementById("Password").value;
					var email = document.getElementById("Email").value;
					var regex = /^[a-zA-Z]+$/;
					var regex1 = /[*@!#%&()^~{}]+/;
					var emailregex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
					
					if (!pass.match(regex1)) {
						document.getElementById("email1").innerHTML = "";
						document.getElementById("pass").innerHTML = "Password must have atleast one special character.";
						if (!email.match(emailregex)) {
							document.getElementById("email1").innerHTML = "Enter valid email id!!";
							return false;
						}
						return false;
					}
					if (!email.match(emailregex)) {
						document.getElementById("pass").innerHTML = "";
						document.getElementById("email1").innerHTML = "Enter valid email id!!";
						return false;
					}

					return true;

				}
			</script>
			<center>
				<h1>WELCOME TO VENDOR UPDATION PAGE</h1>
				<h2> ${error} </h2>
				<form:form modelAttribute="vendor1" action="updatedVendor">
					<table class="table table-hover">
						<tr>
							<th>Name:</th>
							<td><input id="Name" name="name" value="${vendor1.name}" required="required" /></td>
						</tr>
						<tr>
							<th>Email:</th>
							<td><input id="Email" name="e_mail" value="${vendor1.e_mail}" readonly="readonly" /></td>
						</tr>
						<tr>
							<th>Password:</th>
							<td><input id="Password" name="password" value="${vendor1.password}"
									type="password" required="required" /></td>
									<td><div id="pass"></div></td>
						</tr>
						<tr>
							<th>Date Of Birth:</th>
							<td><input name="DOB" value="${vendor1.DOB}" type="date" class="form-control" max="${date1}"
									required="required" /></td>
						</tr>
						<tr>
							<th>Address:</th>
							<td><input name="address" value="${vendor1.address}" required="required" /></td>
						</tr>
						<tr>
							<th>Phone Number:</th>
							<td><input name="phone_no" value="${vendor1.phone_no}" type="text" maxlength="10"
									required="required" /></td>
						</tr>
						
						<tr>
							<th><input type="submit" value="Edit"
								onclick="return validate()"></th>
						</tr>

					</table>

				</form:form>
			</center>
</body>
</html>