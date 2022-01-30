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
<style type="text/css">
.main {
	height: 320px;
	width: 320px;
	margin: auto;
	z-index: -1;
	opacity: 1;
	filter: alpha(opacity = 100);
}
</style>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<script type="text/javascript">
		function Toggle() {
			var temp = document.getElementById("password");
			if (temp.type === "password") {
				temp.type = "text";
			} else {
				temp.type = "password";
			}
		}
	</script>
	<center>
		<h1 align="center">WELCOME TO USER LOGIN PAGE</h1>
		<div>
			<img alt="" src="/images/userimage.jpg" title="User Login"/>
		</div>
		<h2>${message}</h2>
		<div class="main">
			<form action="/userhomepage" method="post">
				<table class="table table-hover">
					<tr>
						<th>Email ID</th>
						<td><input type="email" placeholder="Enter your Email ID"
							name="e_mail" id="e_mail" required="required" /></td>
					</tr>
					<tr>
						<th>Password</th>
						<td><div class="input-group">
								<input type="password" placeholder="Enter your Password"
									name="password" id="password" required="required" /><span
									class="input-group-btn">
									<button class="btn btn-default reveal" type="button"
										onclick="Toggle()">
										<i class="glyphicon glyphicon-eye-open"></i>
									</button>
								</span>
							</div></td>
					</tr>
					<tr>
						<td><input type="submit" value="Login" /></td>
						<td><a href="/registerUser">Register User</a></td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>