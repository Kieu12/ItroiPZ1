<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Airplane Details</title>
    <link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<div>
    <h1>Airplane Details</h1>
    <c:choose>
        <c:when test="${not empty errorMsg}">
            <h2>${errorMsg}</h2>
        </c:when>
        <c:otherwise>
            <div>
                <ul>
                    <li>Airplane Title: ${airplane.airplaneTitle}</li>
                    <li>Duration: ${airplane.duration}</li>
                    <li>Show Type: ${airplane.destination}</li>
                </ul>

                <h3>Tickets:</h3>
                <table border="1"> <!-- Add the border attribute here -->
                    <thead>
                    <tr>
                        <th>Ticket Number</th>
                        <th>Seat Number</th>
                        <th>Purchase Date</th>
                        <th>Passenger Name</th>
                        <th>Passenger Surname</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="ticket" items="${airplane.ticket}">
                        <tr>
                            <td>${ticket.ticketNumber}</td>
                            <td>${ticket.seatNumber}</td>
                            <td>${ticket.purchaseDate}</td>
                            <td>${ticket.passenger.name}</td>
                            <td>${ticket.passenger.surname}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
