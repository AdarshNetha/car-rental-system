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
        background: #000;
        color: #f1c40f;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 100%;
        max-width: 420px;
        background: rgba(10, 10, 10, 0.9);
        border: 2px solid #0a4dff;
        border-radius: 15px;
        padding: 25px;
        box-shadow: 0 0 20px rgba(10, 77, 255, 0.8);
        text-align: center;
    }

    h1 {
        margin-bottom: 20px;
        font-size: 26px;
        text-shadow: 0 0 10px #0a4dff;
    }

    .details {
        text-align: left;
        font-size: 15px;
        line-height: 1.6;
        margin-bottom: 20px;
        color: #e0e0e0;
    }

    .details b {
        color: #f1c40f;
    }

    button {
        width: 100%;
        padding: 14px;
        font-size: 18px;
        color: #f1c40f;
        border: 2px solid #0a4dff;
        border-radius: 50px;
        background: transparent;
        cursor: pointer;
        transition: 0.3s;
    }

    button:hover {
        background: #0a4dff;
        color: #fff;
        box-shadow: 0 0 15px #0a4dff;
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
            font-size: 16px;
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