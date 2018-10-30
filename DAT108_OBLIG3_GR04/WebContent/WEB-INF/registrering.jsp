<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/styles.css'>
<title>Påmelding</title>
</head>
<body>
	<div class="mainEl">
	<h2 class="title">Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input 
					placeholder="fornavn.." type="text"
					name="fornavn" value="${skjema.fornavn}" /> 
					<font color="red">${skjema.fornavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input 
					placeholder="etternavn.." type="text"
					name="etternavn" value="${skjema.etternavn}" /> 
					<font color="red">${skjema.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input 
					placeholder="mobilnr.." type="text"
					name="mobil" value="${skjema.mobil}" /> 
					<font color="red">${skjema.mobilFeil}${brukerTatt}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					name="passord" value="${skjema.passordEn}" placeholder="Minst 5 tegn.." /> 
					<font color="red">${skjema.passordFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					type="password" name="passordRepetert"
					value="${skjema.passordTo}" /> 
					<font color="red">${skjema.passordFeilLikhet}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label> 
				<input <c:if test="${skjema.kjonn == 'mann'}"> checked="true" </c:if> type="radio" name="kjonn" value="mann" />
				mann
				<input <c:if test="${skjema.kjonn == 'kvinne'}"> checked="true" </c:if> type="radio" name="kjonn" value="kvinne"/>kvinne
				<font color="red">${skjema.kjonnFeil}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary knapp">Meld
					meg på</button>
			</div>
		</fieldset>
	</form>
	</div>
</body>
</html>