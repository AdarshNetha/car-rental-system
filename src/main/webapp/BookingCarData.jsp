<%@page import="assets.Booking"%>
<%@page import="assets.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 15px;
        font-family: "Poppins", sans-serif;
        background: #0b0f1a;   /* deep dark blue-black */
        color: #e5e7eb;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 100%;
        max-width: 420px;
        background: #111827;   /* dark gray */
        border: 1px solid #2563eb; /* soft blue */
        border-radius: 16px;
        padding: 26px;
        box-shadow: 0 10px 30px rgba(37, 99, 235, 0.35);
        text-align: center;
    }

    h1 {
        margin-bottom: 18px;
        font-size: 26px;
        color: #facc15; /* soft gold */
        text-shadow: none;
    }

    .details {
        text-align: left;
        font-size: 15px;
        line-height: 1.7;
        margin-bottom: 22px;
        color: #d1d5db;
    }

    .details b {
        color: #facc15;
        font-weight: 600;
    }

    button {
        width: 100%;
        padding: 14px;
        font-size: 16px;
        color: #ffffff;
        border: none;
        border-radius: 50px;
        background: #2563eb; /* primary blue */
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background: #1d4ed8;
        box-shadow: 0 0 14px rgba(37, 99, 235, 0.6);
    }

    /* 📱 Mobile */
    @media (max-width: 480px) {
        h1 {
            font-size: 22px;
        }

        .details {
            font-size: 14px;
        }

        button {
            font-size: 15px;
            padding: 12px;
        }
    }
</style>


</head>
<body>
<% Car c=(Car)request.getAttribute("car"); %>
<% Booking booking=(Booking)request.getAttribute("bookingData");%>
<div class="container">
    <h1>Booking Successful ✅</h1>

    <div class="details">
        <b>Booking ID:</b> <%= booking.getCarid() %><br>
        <b>Booked Car:</b> <%= booking.getCname() %><br>
        <b>From Date:</b> <%= booking.getFromDate() %><br>
        <b>To Date:</b> <%= booking.getToDate() %><br><br>

        <b>Car Name:</b> <%= c.getName() %><br>
        <b>Car Model:</b> <%= c.getModel() %><br>
        <b>Car Price:</b> ₹<%= c.getPrice() %><br>
        <b>Car Number:</b> <%= c.getNumber() %>
    </div>

    <form action="customerservice">
        <button type="submit">Go To Home Page</button>
    </form>
</div>

</body>
</html>