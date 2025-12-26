<%@page import="assets.Booking"%>
<%@page import="assets.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {
            margin: 0;
            padding: 0;
            font-family: "Poppins", sans-serif;
            background: #000;
            color: #f1c40f;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
         button {
            display: inline-block;
            padding: 15px 35px;
            margin: 10px;
            font-size: 20px;
            text-decoration: none;
            color: #f1c40f;
            border: 2px solid #0a4dff;
            border-radius: 50px;
            transition: 0.3s;
            background: transparent;
        }

        button:hover {
            background: #0a4dff;
            color: #fff;
            box-shadow: 0 0 15px #0a4dff;
        }
        
		div{
			height: 300px;
			width: 200px;
			display: flex;
			justify-content: center;
			align-items: center;
			flex-direction: column;		
			}
</style>
</head>
<body>
<% Car c=(Car)request.getAttribute("car"); %>
<% Booking booking=(Booking)request.getAttribute("bookingData");%>
<div id="container">
	<h1>Booking Succesfull</h1>
	<b>Booking Id: </b><%=booking.getCarid()%> <br>
	<b>Booked Car</b><%=booking.getCname()%><br>
	<b>From Date</b> <%=booking.getFromDate()%><br>
	<b>To Date</b>  <%=booking.getToDate()%><br>
	<b>Car Name</b><%=c.getName()%>
	<b>Car Model</b> <%=c.getModel()%>
	<b>Car Price</b> <%=c.getPrice()%>
	<b>Car Number</b> <%=c.getNumber()%>
	<form action="customerservice">
	<button>Go To Home Page</button>	
	</form>

	
</div>
</body>
</html>