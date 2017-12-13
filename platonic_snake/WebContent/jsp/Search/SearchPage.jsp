<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.requestURI}" />
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<meta charset="ISO-8859-1">
	<title>Suchergebnisse</title>
</head>
<body>

<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
	<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "ausgabefeld">
			<h2>Suchergebnisse</h2>
			<table>
				<tr>
					<th>Name</th>
					<th>Wohnort</th>
					<th>Interessen</th>
				</tr>
				<c:forEach var="user" items="${users}" varStatus="status">
					<tr>
						<td>${user.username}</td>
						<td>${user.location}</td>
						<td>${user.interests}</td>
					</tr>
					<c:if test="${not status.last}">,</c:if>
				</c:forEach>
			</table>
		</div>
	</div>
</main>

<div class = "right">
	<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>
</body>
</html>


