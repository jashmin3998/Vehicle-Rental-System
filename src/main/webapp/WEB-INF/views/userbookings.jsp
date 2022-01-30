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
<title>User My Bookings</title>
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
<c:forEach items="${bd}" var="book">
<tr>
<th>${book.bookingId}</th>
<th>${book.name}</th>
<th>${book.useremail}</th>
<th>${book.vendorname}</th>
<th>${book.vendoremail}</th>
<th>${book.bookingDate}</th>
<th>${book.vehiclenumber}</th>
<th>${book.vehicletype}</th>
<th>${book.vehiclecolour}</th>
<th>${book.price}</th>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>