<%@page import="assets.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booked Cars</title>

<style>
    body {
        margin: 0;
        padding: 30px;
        display: flex;
        flex-wrap: wrap;
        gap: 25px;
        background-color: #0b0f1a; /* deep black-blue */
        font-family: 'Segoe UI', Arial, sans-serif;
        color: #ffffff;
    }

    .card {
        height: auto;
        width: 260px;
        background-color: #111827; /* rich black */
        border: 1px solid #d4af37; /* gold */
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.6);
        padding: 18px;
    }

    .card h3 {
        margin: 0 0 12px 0;
        text-align: center;
        color: #4169e1; /* royal blue */
        letter-spacing: 1px;
        font-size: 18px;
    }

    .info {
        font-size: 14px;
        margin-bottom: 8px;
        color: #f5f5f5;
    }

    .label {
        color: #d4af37; /* gold */
        font-weight: 600;
    }

    form {
        display: flex;
        flex-direction: column;
        gap: 8px;
    }

    input {
        background-color: #0f172a;
        color: #ffffff;
        border: 1px solid #4169e1;
        border-radius: 6px;
        padding: 6px;
        font-size: 13px;
        text-align: center;
    }

    input:focus {
        outline: none;
        border-color: #d4af37;
    }

    button {
        margin-top: 12px;
        padding: 10px;
        background-color: #4169e1; /* royal blue */
        color: #ffffff;
        border: none;
        border-radius: 6px;
        font-size: 14px;
        font-weight: 600;
        cursor: pointer;
        letter-spacing: 0.5px;
        transition: 0.3s ease;
    }

    button:hover {
        background-color: #d4af37; /* gold */
        color: #000000;
    }
</style>
</head>

<body>

<%
    List<Booking> bookedcars = (List<Booking>) request.getAttribute("bookinglist");
    for (Booking b : bookedcars) {
%>

<div class="card">
    <h3>Booking Details</h3>

    <form action="delete-booking" method="post">
        Car Id:<input name="cid" value="<%= b.getCarid() %>" readonly>
        Booking Id:<input name="bid" value="<%= b.getId() %>" readonly>

        <div class="info"><span class="label">Customer:</span> <%= b.getCname() %></div>
        <div class="info"><span class="label">Phone:</span> <%= b.getPhno() %></div>
        <div class="info"><span class="label">From:</span> <%= b.getFromDate() %></div>
        <div class="info"><span class="label">To:</span> <%= b.getToDate() %></div>

        <button type="submit">Returned</button>
    </form>
</div>

<% } %>

</body>
</html>
