<!DOCTYPE html>
<HTML>
<head>
	<link rel="stylesheet" href="../../css/style1.css" type="text/css">
	<title>Registrierung</title>
</head>
<BODY>

<%@ includefile="/jsp/Fragments/header.jspf" %>

<div class = "left">
<br>
</div>
<main>
	<div class = "ausrichtung">
		<div class = "formularfeld">
			<h2> Registrierung</h2>
			<base href="${pageContext.request.requestURI}" />
			<form action="/platonic_snake/UserCreationServlet" method = "post" enctype = "multipart/form-data">
				<label for = "username">Username:*</label>
				<input type=text name=username size=20 required><BR>
				<br>
				<label for = "email">Email:*</label>
				<input type=text name=email SIZE=20 required><BR>
				<br>
				<label for = "password">Passwort:*</label>
				<input type=text name = "password" id = "password" size=20 required><BR>
				<br>
				<label for = "cpassword">Passwort bestätigen:*</label>
				<input type=text name = "cpassword" id = "cpassword" size=20 required><BR>
				<br>
				<label for = "birthday">Geburtsdatum:</label>
				<input type=date name=birthday><br>
				<br>
				<label for = "location">Wohnort:</label>
				<input type=text name=location size=20><BR>
				<br>
				<label for = "interests">Interessen:</label>
				<input type=text name=interests size=20><BR>
				<br>
				<label for = "photo"> Foto: </label>
				<input type = file name = photo id ="photo" size=60 accept=image/*><br>
				<br>
				<label for = "Absenden">* Pflichtfeld</label>
				<input type=SUBMIT name=Absenden>
			</form>
		</div>
	</div>
</main>


<script type="text/javascript">
var password = document.getElementById("password");
var cpassword = document.getElementById("cpassword");

function validatePassword(){
  if(password.value != cpassword.value) {
    cpassword.setCustomValidity("Passwords Don't Match");
  } else {
    cpassword.setCustomValidity('');
  }
}

password.onchange = validatePassword;
cpassword.onkeyup = validatePassword;
</script>

<div class = "right">
<br>
</div>
<%@ includefile="/jsp/Fragments/footer.jspf" %>
</body>
</html>


