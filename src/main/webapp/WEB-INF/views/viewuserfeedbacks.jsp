<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel='icon' href='/images/favicon.ico' type='image/x-icon'/>
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
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Admin View User Feedback</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/gotovendorhome">Home</a></li>
			</ul>

		</div>
	</nav>
<div class="main">
<table class="table table-hover">
<tr>
<th>User EmailID</th>
<th>User Name</th>
<th>Feedback</th>
<th>Ratings</th>
<th>Feedback Date</th>
</tr>

<c:forEach items="${feedbacks}" var="feedback">
<tr>
<th>${feedback.useremail}</th>
<th>${feedback.username}</th>
<th>${feedback.feedback}</th>
<th>${feedback.rating}</th>
<th>${feedback.currentDate}</th>
</tr>
</c:forEach>

</table>
</div>

</body>
</html>