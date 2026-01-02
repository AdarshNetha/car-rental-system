<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ page import="java.util.List" %>
<%@ page import="assets.Booking" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booked Cars</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
    * {
        box-sizing: border-box;
    }

    body {
        margin: 0;
        padding: 20px;
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
        justify-content: center;
        background-color: #0b0f1a;
        font-family: 'Segoe UI', Arial, sans-serif;
        color: #ffffff;
    }

    .card {
        width: 100%;
        max-width: 280px;
        background-color: #111827;
        border: 1px solid #d4af37;
        border-radius: 12px;
        box-shadow: 0 8px 20px rgba(0, 0, 0, 0.6);
        padding: 18px;
    }

    .card h3 {
        margin-bottom: 14px;
        text-align: center;
        color: #4169e1;
        letter-spacing: 1px;
        font-size: 18px;
    }

    .info {
        font-size: 14px;
        margin-bottom: 6px;
        color: #f5f5f5;
    }

    .label {
        color: #d4af37;
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
        padding: 7px;
        font-size: 13px;
        text-align: center;
    }

    input:focus {
        outline: none;
        border-color: #d4af37;
    }

    button {
        margin-top: 10px;
        padding: 12px;
        background-color: #4169e1;
        color: #ffffff;
        border: none;
        border-radius: 8px;
        font-size: 14px;
        font-weight: 600;
        cursor: pointer;
        transition: 0.3s ease;
    }

    button:hover {
        background-color: #d4af37;
        color: #000000;
    }

    .no-data {
        color: #d4af37;
        font-size: 20px;
        margin-top: 40px;
    }

    /* 📱 Mobile */
    @media (max-width: 480px) {
        body {
            padding: 12px;
        }

        .card {
            max-width: 100%;
        }

        button {
            padding: 14px;
            font-size: 15px;
        }
    }
</style>
</head>

<body>

<%
    List<Booking> bookedcars =
        (List<Booking>) request.getAttribute("bookinglist");

    if (bookedcars != null && !bookedcars.isEmpty()) {
        for (Booking b : bookedcars) {
%>

<div class="card">
    <h3>Booking Details</h3>

    <form action="delete-booking" method="post">
        <input name="cid" value="<%= b.getCarid() %>" readonly>
        <input name="bid" value="<%= b.getId() %>" readonly>

        <div class="info"><span class="label">Customer:</span> <%= b.getCname() %></div>
        <div class="info"><span class="label">Phone:</span> <%= b.getPhno() %></div>
        <div class="info"><span class="label">From:</span> <%= b.getFromDate() %></div>
        <div class="info"><span class="label">To:</span> <%= b.getToDate() %></div>

        <button type="submit">Returned</button>
    </form>
</div>

<%
        }
    } else {
%>

<div class="no-data">No Booked Cars Found</div>

<%
    }
%>

</body>
</html>
