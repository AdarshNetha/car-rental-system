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
        background: #000000;              /* PURE BLACK */
        color: #e5e5e5;
        min-height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        width: 100%;
        max-width: 420px;
        background: #111111;              /* DARK CARD */
        border: 1px solid #1e40af;        /* SOFT BLUE BORDER */
        border-radius: 16px;
        padding: 26px;
        text-align: center;
        box-shadow:
            0 0 12px rgba(30, 64, 175, 0.35),   /* BLUE GLOW */
            0 0 8px rgba(250, 204, 21, 0.15);   /* GOLD TINT */
    }

    h1 {
        margin-bottom: 18px;
        font-size: 26px;
        color: #facc15;                   /* SOFT GOLD */
        font-weight: 600;
        text-shadow:
            0 0 6px rgba(250, 204, 21, 0.6);   /* GOLD GLOW */
    }

    .details {
        text-align: left;
        font-size: 15px;
        line-height: 1.7;
        margin-bottom: 22px;
        color: #d1d1d1;
    }

    .details b {
        color: #ffffff;
        font-weight: 500;
    }

    button {
        width: 100%;
        padding: 14px;
        font-size: 16px;
        color: #ffffff;
        background: #000000;
        border: 1.5px solid #1e40af;      /* BLUE EDGE */
        border-radius: 30px;
        cursor: pointer;
        font-weight: 600;
        transition: 0.3s ease;
        box-shadow: 0 0 8px rgba(30, 64, 175, 0.4);
    }

    button:hover {
        background: #111111;
        box-shadow:
            0 0 14px rgba(30, 64, 175, 0.8),   /* BLUE GLOW */
            0 0 10px rgba(250, 204, 21, 0.5);  /* GOLD GLOW */
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