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
					id="inputFornavn" 
					placeholder="fornavn.." type="text"
					name="fornavn" value="${skjema.fornavn}" /> 
					<font id="feilFornavn" color="#d72d1d">${skjema.fornavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input 
					id="inputEtternavn"
					placeholder="etternavn.." type="text"
					name="etternavn" value="${skjema.etternavn}" /> 
					<font id="feilEtternavn" color="#d72d1d">${skjema.etternavnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input 
					id="inputMobil"
					placeholder="mobilnr.." type="text"
					name="mobil" value="${skjema.mobil}" /> 
					<font id="feilMobil" color="#d72d1d">${skjema.mobilFeil}${brukerTatt}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input type="password"
					id="passordEnInput"
					name="passord" value="${skjema.passordEn}" placeholder="Minst 5 tegn.." /> 
					<font id="feilPassord" color="#d72d1d">${skjema.passordFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input
					id="passordToInput"
					type="password" name="passordRepetert"
					value="${skjema.passordTo}" /> 
					<font id="feilPassordMatch" color="#d72d1d">${skjema.passordFeilLikhet}</font>
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
	<script defer type="text/javascript" charset="ISO-8859-1" src="${pageContext.request.contextPath}/JS/scripts.js"></script>
</body>
</html>