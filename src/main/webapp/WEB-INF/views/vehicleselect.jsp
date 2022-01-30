<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel='icon' href='/images/favicon.ico' type='image/x-icon'/>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
    align-content: center;
}

.left-element {
    display: inline-block;
    float: left;
}

.right-element {
    display: inline-block;
    float: right;
}
</style>
<meta charset="ISO-8859-1">
<title>Admin Select Vehicle</title>
</head>
<body>
<nav role="navigation" class="navbar navbar-default">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/gotovendorhome"><img src="/images/back.jpg" width="30" height="30" title="Back"/></a></li>
			</ul>

		</div>
	</nav>
<h1 align="center">SELECT VEHICLE TYPE</h1>
<div class="container">
<div class="left-element">
<a href="/twowheelers1"><img alt="twowheeler" width="500" height="300" src="/images/bike.jpg" title="Two Wheelers"></a>
</div>
<div class="right-element">
<a href="/fourwheelers1"><img alt="twowheeler" width="500" height="300" src="/images/car.jpg" title="Four Wheelers"></a>
</div>
</div>
</body>
</html>