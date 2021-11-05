<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0" />
	<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css" media="all" />
	
</head>
<body>
	
	<header class="container"></header>
	
	<%@include file="main_nav.jsp" %>
	
	<main class="container">
		<h1>${headline}</h1>
			
		<c:choose>
			<%-- IF --%>
			<c:when test="${empty tasks}">
				<p>Aktuell keine Tasks verfügbar</p>
			</c:when>
			
			<%-- ELSE --%>
			<c:otherwise>
				<table class="table">
					<tr>
						<th>Titel</th>
						<th>Beschreibung</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${tasks}" var="task">
						<tr>
							<td>${task.title}</td>
							<td>${task.description}</td>
							<td>
								<a href="/delete/${task.id}" class="btn btn-danger">Löschen</a>
								<a href="/edit/${task.id}" class="btn btn-warning">Bearbeiten</a>
								
								<c:if test="${task.isDone()}">
									<a href="/undone/${task.id}" class="btn btn-info">Nicht Erledigt!</a>
								</c:if>
								
								<c:if test="${!task.isDone()}">
									<a href="/done/${task.id}" class="btn btn-success">Erledigt!</a>
								</c:if>
							</td>
						<tr>
					</c:forEach>
				</table>
			</c:otherwise>
			
			</c:choose>
	</main>
	
	<footer class="container"></footer>
	
</body>
</html>