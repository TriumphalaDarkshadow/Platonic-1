<!DOCTYPE html>
<jsp:useBean id="user" class="user.UserData" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../css/style1.css" type="text/css">
<title>your data</title>
<base href="${pageContext.request.requestURI}" />
</head>
<body>
<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "ausgabefeld">
			<h1>Herzlich Willkommen ${user.username} !</h1>
			
			<p>Du hast folgende Daten angegeben:</p>
				
			<emp>Bild:</emp><img src = "BildServlet?username=${user.username}">		
			<table>
				<tr>
					<th>Name</th>
					<td>${user.username}</td>
				</tr>
				<tr>
					<th>Email</th>
					<td>${user.email}</td>
				</tr>
				<tr>
					<th>Passwort</th>
					<td>${user.password}</td>
				</tr>
				<tr>
					<th>Geburtstag</th>
					<td>${user.birthday}</td>
				</tr>
				<tr>
					<th>Wohnort</th>
					<td>${user.location}</td>
				</tr>
				<tr>
					<th>Interessen</th>
					<td>${user.interests}</td>
				</tr>
			</table>
			<br>
			<p>Du kannst deine Daten jederzeit im Profil ändern.</p>
			<h4>Viel Spaß bei Platonic !</h4>
		</div>
	</div>
</main>

<div class = "right">
<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>
</body>
</html>
