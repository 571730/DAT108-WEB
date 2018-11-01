<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/styles.css'>
<title>Logg inn</title>
</head>
<body>
	<div class="mainEl">
	<h2 class="title">Logg inn</h2>
	<div class="spacer">
	<p>${notLoggedIn}</p>
	<p>
		<font color="red">${skjemaLogg.feilInnlogging}</font>
	</p>
	</div>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="password"
					name="passord" />
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary knapp">Logg
					inn</button>
			</div>
		</fieldset>
	</form>
	</div>
</body>
</html>