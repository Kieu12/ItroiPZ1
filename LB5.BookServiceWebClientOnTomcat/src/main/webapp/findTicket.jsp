<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of articles</title>
<link href="css/default.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="jspf/head.jspf"></jsp:include>
 	<div>
 		<form action="findTicket" method="get">
 			<label for="ticketId">Ticket number: </label>
 			<input type="text" name="ticketId" id="ticketId"/>
 			<input type="submit" value="Find" />
 		</form>
 	</div>
</body>
</html>