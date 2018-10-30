<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/styles.css'>
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<div class="mainEl">
		<h2 class="title">Påmeldingsbekreftelse</h2>
		
		<div class="spacer">
			<p>Påmeldingen er mottatt for</p>
			<p>
				&nbsp;&nbsp;&nbsp;${skjema.fornavn}<br />
				&nbsp;&nbsp;&nbsp;${skjema.etternavn}<br />
				&nbsp;&nbsp;&nbsp;${skjema.mobil}<br /> &nbsp;&nbsp;&nbsp;${skjema.kjonn}
			</p>
			<div class="boxlink">
				<a class="link" href="deltakerliste">Gå til deltagerlisten</a>
			</div>
		</div>
	</div>
	
</body>
</html>