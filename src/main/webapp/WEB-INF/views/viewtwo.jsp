<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Vendor View Two Wheelers</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/twowheelersvendor"><img src="/images/back.jpg" width="30" height="30" title="Back"/></a></li>
			</ul>
			
		</div>
	</nav>
<table class="table table-hover">
<tr><td>Vehicle Number</td><td>${two.vehiclenumber}</td></tr>
<tr><td>Vehicle Type</td><td>${two.vehicletype}</td></tr>
<tr><td>Vehicle Colour</td><td>${two.vehiclecolour}</td></tr>
<tr><td>Engine Number</td><td>${two.enginenumber}</td></tr>
<tr><td>Chassis Number</td><td>${two.chassisnumber}</td></tr>
<tr><td>Price</td><td>${two.price}</td></tr>
<tr><td>E Mail</td><td>${two.e_mail}</td></tr>
</table>
</body>
</html>