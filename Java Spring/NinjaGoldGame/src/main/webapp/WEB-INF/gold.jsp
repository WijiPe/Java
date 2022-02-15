<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Ninja Gold Game</title>
</head>
<body>
	<h1 class="head">Your Gold: ${gold}</h1>
	
	<div class="form">
		<form class="place" action='/process' method='POST'>
			<h2>Farm</h2>
			<h3>(earns 10-20 gold)</h3>
			<input type="hidden" name="place" value="farm" />
			<button>Find Gold!</button>
		</form>
		<form class="place" action='/process' method='POST' name="farm">
			<h2>Cave</h2>
			<h3>(earns 5-10 gold)</h3>
			<input type="hidden" name="place" value="cave" />
			<button>Find Gold!</button>
		</form>
		<form class="place" action='/process' method='POST' name="farm">
			<h2>House</h2>
			<h3>(earns 2-5 gold)</h3>
			<input type="hidden" name="place" value="house" />
			<button>Find Gold!</button>
		</form>
		<form class="place" action='/process' method='POST' name="farm">
			<h2>Casino!</h2>
			<h3>(earns/takes 0-50 gold)</h3>
			<input type="hidden" name="place" value="casino" />
			<button>Find Gold!</button>
		</form>
		<form class="place" action='/process' method='POST' name="farm">
			<h2>Spa</h2>
			<h3>(takes 5-20 gold)</h3>
			<input type="hidden" name="place" value="spa" />
			<button>Find Gold!</button>
		</form>
	</div>
	<div class="textarea">	
		<h2 class="head">Activities:</h2>
		<textarea rows="25" cols="200">
			<c:forEach var="activity" items="${activities}">
				<c:out value="${activity}"></c:out>
			</c:forEach>
		</textarea>
		<a href="http://localhost:8080/gold/reset"><button >restart</button></a>
	</div>

		
		
	
</body>
</html>