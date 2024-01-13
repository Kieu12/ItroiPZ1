<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>List of airplanes</title>
	<link href="css/default.css" rel="stylesheet">
</head>
<body>
<jsp:include page="jspf/head.jspf"></jsp:include>
<c:choose>
	<c:when test="${empty airplanes}">
		<h2>No airplanes found</h2>
	</c:when>
	<c:otherwise>
		<table class="brd">
			<thead class="tabhead">
			<tr>
				<th class="brd">Airplane ID</th>
				<th class="brd">Airplane Title</th>
				<th class="brd">Duration</th>
				<th class="brd">Show Type</th>
				<th class="brd">Actions</th> <!-- Added column for actions -->
			</tr>
			</thead>
			<tbody>
			<c:forEach var="airplane" items="${airplanes}">
				<tr>
					<td class="brd">${airplane.id}</td>
					<td class="brd">${airplane.airplaneTitle}</td>
					<td class="brd">${airplane.duration}</td>
					<td class="brd right">${airplane.destination}</td>
					<td class="brd">
						<form action="deleteAirplane" method="post">
							<input type="hidden" name="airplaneId" value="${airplane.id}">
							<button type="submit">Delete</button>
						</form>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
</body>
</html>
