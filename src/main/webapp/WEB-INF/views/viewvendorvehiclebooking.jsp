<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<title>Vendor View Vehicle Bookings</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/Vhome">Home</a></li>
			</ul>

		</div>
	</nav>
<center>
<table class="table table-hover">
<tr>
<th>Booking ID</th>
<th>User Name</th>
<th>User EmailID</th>
<th>Vendor Name</th>
<th>Vendor EmailID</th>
<th>Booking Date</th>
<th>Vehicle Number</th>
<th>Vehicle Type</th>
<th>Vehicle Colour</th>
<th>Price</th>
</tr>
<c:forEach items="${book}" var="bd">
<tr>
<th>${bd.bookingId}</th>
<th>${bd.name}</th>
<th>${bd.useremail}</th>
<th>${bd.vendorname}</th>
<th>${bd.vendoremail}</th>
<th>${bd.bookingDate}</th>
<th>${bd.vehiclenumber}</th>
<th>${bd.vehicletype}</th>
<th>${bd.vehiclecolour}</th>
<th>${bd.price}</th>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>