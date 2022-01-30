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
<style type="text/css">
@import url(//use.fontawesome.com/releases/v5.4.2/css/all.css);

/* Ratings widget */
.rate {
    display: inline-block;
    border: 0;
}
/* Hide radio */
.rate > input {
    display: none;
}
/* Order correctly by floating highest to the right */
.rate > label {
    float: right;
}
/* The star of the show */
.rate > label:before {
    display: inline-block;
    font-size: 1.1rem;
    padding: .3rem .2rem;
    margin: 0;
    cursor: pointer;
    font-family: 'Font Awesome 5 Free';
    font-weight: 900;
    content: "\f005"; /* full star */
}

/* Half star trick */
.rate .half:before {
    content: "\f089"; /* half star no outline */
    position: absolute;
    padding-right: 0;
}

/* Click + hover color */
input:checked ~ label, /* color current and previous stars on checked */
label:hover, label:hover ~ label { color: #73B100;  } /* color previous stars on hover */

/* Hover highlights */
input:checked + label:hover, input:checked ~ label:hover, /* highlight current and previous stars */
input:checked ~ label:hover ~ label, /* highlight previous selected stars for new rating */
label:hover ~ input:checked ~ label /* highlight previous selected stars */ { color: #A6E72D;  }
</style>
<meta charset="ISO-8859-1">
<title>User Feedback</title>

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
<form:form modelAttribute="feedback1" action="/submitfeedback">
<table>
<tr>
<th>User Name</th><th><input type="text" name="username" value="${name}" readonly="readonly"/></th>
</tr>
<tr>
<th>User EmailID</th><th><input type="text" name="useremail" value="${email}" readonly="readonly"/></th>
</tr>
<tr>
<th>Comments or FeedBack</th><th><textarea name="feedback" rows="10" cols="50" required="required">
</textarea>
</th>
</tr>
<tr><th>Ratings For this Application</th><th><fieldset class="rate">
    <input type="radio" id="rating10" name="rating" value="10" /><label for="rating10" title="5 stars"></label>
    <input type="radio" id="rating9" name="rating" value="9" /><label class="half" for="rating9" title="4 1/2 stars"></label>
    <input type="radio" id="rating8" name="rating" value="8" /><label for="rating8" title="4 stars"></label>
    <input type="radio" id="rating7" name="rating" value="7" /><label class="half" for="rating7" title="3 1/2 stars"></label>
    <input type="radio" id="rating6" name="rating" value="6" /><label for="rating6" title="3 stars"></label>
    <input type="radio" id="rating5" name="rating" value="5" /><label class="half" for="rating5" title="2 1/2 stars"></label>
    <input type="radio" id="rating4" name="rating" value="4" /><label for="rating4" title="2 stars"></label>
    <input type="radio" id="rating3" name="rating" value="3" /><label class="half" for="rating3" title="1 1/2 stars"></label>
    <input type="radio" id="rating2" name="rating" value="2" /><label for="rating2" title="1 star"></label>
    <input type="radio" id="rating1" name="rating" value="1" /><label class="half" for="rating1" title="1/2 star"></label>
</fieldset>
</th></tr>
<tr>
<th>Date</th><th><input type="date" name="currentDate" value="${name}" min="${today}" max="${today}"/></th>
</tr>
<tr><th><input type="submit" value="Submit"/></th></tr>
</table>
</form:form>
</center>
</body>
</html>