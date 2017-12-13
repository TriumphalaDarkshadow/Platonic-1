<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.request.requestURI}"/>
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<meta charset="ISO-8859-1">
	<title>Nutzersuche</title>
</head>

<body>
<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
	<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h2>Nutzersuche</h2>
			<form method = "post" action ="/platonic_snake/Search">
				<label for = "username">Username</label>
				<INPUT TYPE=TEXT NAME=username SIZE=20><BR>
				<br>
				<INPUT TYPE=SUBMIT>
			</form>
		</div>
	</div>
</main>

<div class = "right">
	<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>
</body>
</html>


