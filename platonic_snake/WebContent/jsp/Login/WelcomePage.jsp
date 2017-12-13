<!DOCTYPE html>
<jsp:useBean id="user" class="user.UserData" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<html>
<head>
	<base href="${pageContext.request.requestURI}" />
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>your data</title>
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
		</div>
	</div>
</main>

<div class = "right">
<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>
</body>
</html>


