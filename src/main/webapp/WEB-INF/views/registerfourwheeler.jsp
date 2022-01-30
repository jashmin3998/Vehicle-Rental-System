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
<title>Admin Register Four Wheeler</title>
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
				<h1>WELCOME TO FOUR WHEELER REGISTRATION PAGE</h1>
				<h2> ${error} </h2>
				<form:form modelAttribute="four" action="registeredfourwheeler">
					<table class="table table-hover">
						<tr>
							<th>Vehicle Number:</th>
							<td><form:input path="vehiclenumber" required="required" /></td>
						</tr>
						<tr>
							<th>Vehicle Type:</th>
							<td><form:input path="vehicletype" required="required" /></td>
						</tr>
						<tr>
							<th>Vehicle Colour:</th>
							<td><form:input path="vehiclecolour"
									 required="required" /></td>
						</tr>
						<tr>
							<th>Engine Number:</th>
							<td><form:input path="enginenumber" id="enginenumber" onblur="return validate()"
									required="required" /></td>
						</tr>
						<tr>
							<th>Chassis Number:</th>
							<td><input name="chassisnumber" id="chassisnumber" required="required" /></td>
						</tr>
						<tr>
							<th>Price:</th>
							<td><form:input path="price" type="text" 
									required="required" /></td>
						</tr>
						<tr>
							<th>E Mail:</th>
							<td><form:input path="e_mail" type="text" 
									required="required" /></td>
						</tr>
						<tr>
							<th><input type="submit" value="Register"/>
								</th>
							<th><input type="reset" value="Reset" /></th>
						</tr>

					</table>

				</form:form>
			</center>
</body>
</html>