
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../../css/style1.css" type="text/css">
<title>Log In</title>
</head>
<body>

<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
	<br>
</div>

<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h1>Log In</h1>
			<form method = "post" action="/platonic_snake/LoginServlet"> <!-- anstatt Login, LoginServlet anstatt LoginServlet1, LoginServlet -->
				<label for = "username">Username:</label>
				<input type="text" name= "username" SIZE=20><br> 
				<br>
				<label for = "password">Passwort:</label>
				<input type="password" name= "password" SIZE=20><br>
				<br>
				<input type = "submit" value="login"/>
			</form>
			<br>
			<p>Bitte geben Sie hier ihre Log In Daten an oder <a href = "../Create/GetData.jsp">registrieren</a> Sie sich.</p>
		</div>
	</div>
</main>

<div class = "right">
	<br>
</div>

<%@ includefile="/jsp/Fragments/footer.jspf" %>

</body>
</html>


