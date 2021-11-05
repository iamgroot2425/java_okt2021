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
		<form action="/save" method="post">
		
			<input type="hidden" name="id" id="id" value="${task.id}" />
		
			<div class="mb-3">
				<label for="title" class="form-label">Titel</label>
				<input type="text" name="title" id="title" class="form-control" value="${task.title}" />
			</div>
			
			<div class="mb-3">
				<label for="description" class="form-label">Beschreibung</label>
				<textarea type="text" name="description" id="description" class="form-control">${task.description}</textarea>
			</div>
			
			<button type="submit" class="btn btn-success">Speichern</button>
		</form>		
	</main>
	
	<footer class="container"></footer>
	
</body>
</html>