<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>BookTicket</title>
<link rel="shortcut icon" href="./images/logo4.png" type="image/x-icon">
<link rel="stylesheet"
	href="./font-awesome-4.7.0/css/font-awesome.min.css" type="text/css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 20px;
	color: #333;
}

.booking-container {
	margin: auto;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	overflow: hidden;
	background-color: #fff;
	width: 80%;
	padding: 20px;
}

.booking-details {
	display: flex;
	flex-direction: column;
	gap: 15px;
	border-bottom: 1px solid #ddd;
	padding: 15px 0;
}

.booking-details:last-child {
	border-bottom: none;
}

.booking-details h3 {
	margin: 0;
	font-size: 1.5em;
	color: #cf6464;
	letter-spacing: 0.5px;
	padding-left: 33px;
	font-weight: 200;
}

.booking-details .detail {
	display: flex;
	justify-content: space-between;
	padding: 5px 34px;
}

.booking-details .detail label {
	font-weight: bold;
	color: #555;
}

.booking-details .detail span {
	font-weight: normal;
	color: #000;
}

.print-button {
	display: block;
	margin: 20px auto;
	padding: 10px 20px;
	background-color: #cf6464;
	color: #fff;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
	text-align: center;
}

.print-button:hover {
	background-color: #963a3a;
}

@media print {
	.print-button {
		display: none;
	}
}

pre {
	font-size: 1.3em;
	font-weight: 200;
	font-family: Arial, sans-serif;
	color: #625f5f;
	letter-spacing: 1px;
	line-height: 32px;
	margin: 60px 0px 0px 0px;
}

pre span {
	font-weight: 800;
	color: #cf6464;
}

img {
	width: 53px;
	height: 53px;
	margin: 16px 8px -15px 54px;
}

h1 {
	font-size: 1.6em;
	color: #ebe3e3;
	text-shadow: 2px 5px 5px rgba(0, 0, 0);
	font-weight: 500;
	display: inline-block;
}

#nav {
	background-image: url('./images/2.jpg');
	background-size: cover;
	background-position: center;
	margin: -15px;
}
</style>
</head>

<body>
	<div id=nav>
		<img src="./images/logo4.png">
		<h1>
			Book<i class="fa fa-check" aria-hidden="true"
				style="color: #cf6464; font-size: 1.7em;"></i>et
		</h1>
	</div>
	<pre>
    	Welcome, <span><%=request.getSession().getAttribute("username")%></span>!
    			You Have Successfully Booked Your Ticket, Please Download Your Ticket .
    	</pre>
	<div class="booking-container">
		<div class="booking-details">
			<h3>Booking Information</h3>
			<div class="detail">
				<label>From:</label> <span> <%=request.getSession().getAttribute("from")%>
				</span>
			</div>
			<div class="detail">
				<label>To:</label> <span> <%=request.getSession().getAttribute("to")%>
				</span>
			</div>
			<div class="detail">
				<label>Passengers:</label> <span> <%=request.getSession().getAttribute("passengers")%>
				</span>
			</div>
			<div class="detail">
				<label>Journey Type:</label> <span> <%=request.getSession().getAttribute("journeyType")%>
				</span>
			</div>
			<div class="detail">
				<label>Fare:</label> <span style="color: #cf6464; font-weight: 800;">Rs.<%=request.getSession().getAttribute("Fare")%>
				</span>
			</div>
		</div>
	</div>

	<button class="print-button" onclick="window.print();">Print
		Ticket</button>

</body>

</html>