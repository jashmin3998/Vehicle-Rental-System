<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Book Two wheelers</title>
</head>
<body>
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/selecttwowheeler"><img src="/images/back.jpg"
						width="30" height="30" title="Back" /></a></li>
			</ul>

		</div>
	</nav>
	<form:form modelAttribute="bookdetails" action="paytwo">
		<table class="table table-hover">
<tr><th>Name:</th><th><input name="name" value="${user.name}" readonly="readonly"/></th></tr>
<tr><th>User Email:</th><th><input name="useremail" value="${user.e_mail}" readonly="readonly"/></th></tr>
<tr><th>Vendor Name:</th><th><input name="vendorname" value="${vendor.name}" readonly="readonly"/></th></tr>
<tr><th>Vendor Email:</th><th><input name="vendoremail" value="${two.e_mail}" readonly="readonly"/></th></tr>
<tr><th>Vehicle Number:</th><th><input name="vehiclenumber" value="${two.vehiclenumber}" readonly="readonly"/></th></tr>
<tr><th>Vehicle Type:</th><th><input name="vehicletype" value="${two.vehicletype}" readonly="readonly"/></th></tr>
<tr><th>Vehicle Colour:</th><th><input name="vehiclecolour" value="${two.vehiclecolour}" readonly="readonly"/></th></tr>
<tr><th>Price:</th><th><input name="price" value="${two.price}" readonly="readonly"/></th></tr>
<tr><th>Booking Date:</th><th><input name="bookingDate" type="date" min="${date}" max="${date2}" required="required"></th></tr>
<tr><th><input type="submit" value="Confirm Booking"/></th></tr>
		</table>
	</form:form>
</body>
</html>