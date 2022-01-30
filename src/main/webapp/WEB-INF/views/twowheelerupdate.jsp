<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<title>Admin Update Two Wheeler</title>
</head>
<body>
<script type="text/javascript">
function validate(){
	var eng=document.getElementById("enginenumber").value;
	document.getElementById("chassisnumber").value=eng;
	return true;
}
</script>
<center>
				<h1>WELCOME TO TWO WHEELER UPDATION PAGE</h1>
				<h2> ${error} </h2>
				<form:form modelAttribute="tw" action="updatedTwowheeler">
					<table class="table table-hover">
						<tr>
							<th>Vehicle Number:</th>
							<td><input name="vehiclenumber" value="${tw.vehiclenumber}" readonly="readonly" /></td>
						</tr>
						<tr>
							<th>Vehicle Type:</th>
							<td><input name="vehicletype" value="${tw.vehicletype}" required="required" /></td>
						</tr>
						<tr>
							<th>Vehicle Colour:</th>
							<td><input name="vehiclecolour" value="${tw.vehiclecolour}"
									required="required" /></td>
						</tr>
						<tr>
							<th>Engine Number:</th>
							<td><input name="enginenumber" value="${tw.enginenumber}" id="enginenumber" onblur="return validate()"
									required="required" /></td>
						</tr>
						<tr>
							<th>Chassis Number:</th>
							<td><input name="chassisnumber" value="${tw.chassisnumber}" id="chassisnumber" required="required" /></td>
						</tr>
						<tr>
							<th>Price:</th>
							<td><input name="price" value="${tw.price}" type="text"
									required="required" /></td>
						</tr>
						<tr>
							<th>E Mail:</th>
							<td><input name="e_mail" value="${tw.e_mail}" type="text" 
									required="required" /></td>
						</tr>
						<tr>
							<th><input type="submit" value="Edit" />
								</th>
						</tr>

					</table>

				</form:form>
			</center>
</body>
</html>