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
<title>Receipt For Two Wheeler</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/gotouserhome">Home</a></li>
			</ul>

		</div>
	</nav>
<center>
<div class="main">
<table class="table table-hover">
<tr><th>Booking Id:</th><th>${book.bookingId}</th></tr>
<tr><th>User Name:</th><th>${book.name }</th></tr>
<tr><th>User EmailId:</th><th>${book.useremail }</th></tr>
<tr><th>Vendor Name:</th><th>${book.vendorname }</th></tr>
<tr><th>Vendor EmailId:</th><th>${book.vendoremail}</th></tr>
<tr><th>Vehicle Number:</th><th>${book.vehiclenumber}</th></tr>
<tr><th>Vehicle Type:</th><th>${book.vehicletype}</th></tr>
<tr><th>Vehicle Colour:</th><th>${book.vehiclecolour}</th></tr>
<tr><th>Booking Date:</th><th>${book.bookingDate}</th></tr>
<tr><th>Price:</th><th>${book.price}</th></tr>
</table>
</div>
</center>
</body>
</html>