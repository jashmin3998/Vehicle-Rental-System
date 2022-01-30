<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Admin View Vendor</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/gotoviewvendorpage">View Vendors</a></li>
			</ul>
			
		</div>
	</nav>
<table class="table table-hover">
<tr><td>Name</td><td>${vendordetail.name}</td></tr>
<tr><td>Email</td><td>${vendordetail.e_mail}</td></tr>
<tr><td>Password</td><td>${vendordetail.password}</td></tr>
<tr><td>DOB</td><td>${vendordetail.DOB}</td></tr>
<tr><td>Phone Number</td><td>${vendordetail.phone_no}</td></tr>
<tr><td>Address</td><td>${vendordetail.address}</td></tr>
<tr><td>Gender</td><td>${vendordetail.gender}</td></tr>
</table>
</body>
</html>