<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel='icon' href='/images/favicon.ico' type='image/x-icon'/>
<style type="text/css">

* {box-sizing: border-box;}
.mySlides {
	display: none;
}


.slideshow-container {
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}

.page-text {
  background-color: rgb(0,0,0); 
  background-color: rgba(0,0,0, 0.2); 
  color: white;
  font-weight: bold;
  font-size: 20px;
  border: 2px solid #f1f1f1;
  position: fixed; 
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2;
  width: 600px;
  padding: 5px;
  text-align: center;
}

.nav navbar-nav navbar-right li{
	padding-right:10px;
}

.dot {
  height: 15px;
  width: 15px;
  margin: 0 2px;
  background-color: #bbb;
  border-radius: 50%;
  display: inline-block;
  transition: background-color 0.6s ease;
}

.dots{
	padding-top:20px;
}

.active {
  background-color: #717171;
}

.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 5s;
  animation-name: fade;
  animation-duration: 5s;
}

@-webkit-keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@keyframes fade {
  from {opacity: .4} 
  to {opacity: 1}
}

@media only screen and (max-width: 300px) {
  .text {font-size: 11px}
}

</style>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Vendor Home Page</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="/gotovendorselect">Select Vehicle</a></li>
				<li><a href="/viewVendorBooking">View Bookings</a>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/logout">Logout</a></li>
			</ul>

		</div>
	</nav>

<div class = "content">			
		<div class="slideshow-container">
		
				<div class="mySlides fade">
				  <img src="/images/twowheel1.jpg" style="width:100%">
				</div>
		
				<div class="mySlides fade">
				  <img src="/images/twowheel2.jpg" style="width:100%">
				</div>
		
				<div class="mySlides fade">
				  <img src="/images/fourwheel2.jpg" style="width:100%">
				</div>
				
				<div class="mySlides fade">
				  <img src="/images/fourwheel3.jpg" style="width:100%">
				</div>
		</div>

		 <div class = "page-text">			
			<center><h1>Welcome ${vendorlog.name}</h1></center>
			<p style="font-size:20px">Pay | Rent | Use</p>
		</div>

		<div class = "dots" style="text-align:center">
		  <span class="dot"></span> 
		  <span class="dot"></span> 
		  <span class="dot"></span> 
		  <span class="dot"></span>
		</div>
</div>

<script>
var slideIndex = 0;
showSlides();

function showSlides() {
  var i;
  var slides = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 2000); // Change image every 3 seconds
}
</script>

</body>
</html>