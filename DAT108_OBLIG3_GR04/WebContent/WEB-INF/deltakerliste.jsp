<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
	<link rel='stylesheet' type='text/css' href='${pageContext.request.contextPath}/CSS/styles.css'>
<title>Deltagerliste</title>
</head>
<body>
	<div class="mainEl">
	<h2 class="title">Deltagerliste</h2>
	<table class="pure-table center tabell">
		<tr bgcolor="#a200bf">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		
		<c:forEach items="${deltakere}" var="d">
			<c:choose>
				<c:when test="${d.mobil == aktiv}">
	        		<tr bgcolor="#da00d2">
	        	</c:when>
	        	<c:otherwise>
	        		<tr bgcolor="ffffff">
	        	</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${d.kjonn == 'mann'}">
					<td align="center">&#9794</td>
				</c:when>
				<c:otherwise>
					<td align="center">&#9792</td>
				</c:otherwise>
			</c:choose>
			
	            
				<td><c:out value="${d.fornavn}"/> <c:out value="${d.etternavn}"/></td>
				<c:set value="${d.mobil}" var="tlf" />
				<td>${fn:substring(tlf, 0, 3)} ${fn:substring(tlf, 3, 5)} ${fn:substring(tlf, 5, 8)}</td>
            </tr>
		</c:forEach>
		
		<!--  #ffffff andre fargen-->
	</table>
	<div>
		<div class="linkbox">
			<a class="link" href="loggut">Ferdig</a>
		</div>
	</div>
	
	</div>
</body>
</html>