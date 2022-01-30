<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
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
<title>Payment For Four Wheeler</title>
</head>
<body>
<h1 align="center">PAYMENT PAGE</h1>
<div class="main">
	<form:form modelAttribute="card" action="makePaymentforFour">
		<table class="table table-hover">
			<tr>
				<td>Card Number :</td>
				<td><form:input path="cardNumber" type="text"
						required="required" /></td>
			</tr>
			<tr>
				<td>Card Type :</td>
				<td><form:select path="cardType">
						<form:option value="HDFC">HDFC</form:option>
						<form:option value="SBI">SBI</form:option>
						<form:option value="ICICI">ICICI</form:option>
						<form:option value="AXIS">AXIS</form:option>
						<form:option value="UNION">UNION</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Expiration Month :</td>
				<td><form:select path="expirationMonth" required="required">
						<form:option value="Jan">Jan</form:option>
						<form:option value="Feb">Feb</form:option>
						<form:option value="Mar">Mar</form:option>
						<form:option value="Apr">Apr</form:option>
						<form:option value="May">May</form:option>
						<form:option value="Jun">Jun</form:option>
						<form:option value="Jul">Jul</form:option>
						<form:option value="Aug">Aug</form:option>
						<form:option value="Sep">Sep</form:option>
						<form:option value="Oct">Oct</form:option>
						<form:option value="Nov">Nov</form:option>
						<form:option value="Dec">Dec</form:option>
					</form:select></td>
			</tr>
			<tr>
				<td>Expiration Year :</td>
				<td><form:select path="expirationYear" required="required">
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
						<option value="2023">2023</option>
						<option value="2024">2024</option>
						<option value="2025">2025</option>
						<option value="2026">2026</option>
						<option value="2027">2027</option>
						<option value="2028">2028</option>
						<option value="2029">2029</option>
						<option value="2030">2030</option>
						<option value="2031">2031</option>
						<option value="2032">2032</option>
						<option value="2033">2033</option>
						<option value="2034">2034</option>
						<option value="2035">2035</option>
						<option value="2036">2036</option>
						<option value="2037">2037</option>
						<option value="2038">2038</option>
						<option value="2039">2039</option>
						<option value="2040">2040</option>
					</form:select></td>
			</tr>
			<tr>
				<td>CVV :</td>
				<td><form:input path="cvv" type="password" maxlength="3"
						required="required" /></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><input name="price" value="${price}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>E Mail :</td>
				<td><input path="e_mail" name="e_mail" type="text"
					value="${e_mail}" readonly="readonly"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Make Payment"/></td>
			</tr>
		</table>
	</form:form>
	</div>
</body>
</html>