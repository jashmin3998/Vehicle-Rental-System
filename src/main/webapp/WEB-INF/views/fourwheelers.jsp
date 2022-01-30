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
<title>Admin Four Wheeler</title>
</head>
<body>
	<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/viewVehileType"><img src="/images/back.jpg" width="30" height="30" title="Back"/></a></li>
				<li><a href="/gotovendorhome">Home</a></li>
			</ul>

		</div>
	</nav>
	<table class="table table-hover">
<c:if test="${empty3 == 0}"><tr><th> ${emptyfour} </th></tr></c:if>
<c:if test="${empty3 gt 0}">
<tr><th>Name</th></tr>
<c:forEach items="${fourwheel}" var="four">
<tr><th>${four.vehicletype}</th><th>${four.vehiclecolour}</th><td><a type="button" class="btn btn-primary" href="/viewfourwheeler?vehiclenumber=${four.vehiclenumber}">View</a></td>
<td><a type="button" class="btn btn-warning" href="/updatefourwheeler?vehiclenumber=${four.vehiclenumber}">Update</a></td><td><a type="button" class="btn btn-danger" href="/deletefourwheeler?vehiclenumber=${four.vehiclenumber}">Delete</a></td>
</c:forEach>
</c:if>
<tr><td><a href="/addfourwheeler" type="button" class="btn btn-success">Add</a>
</table>
</body>
</html>