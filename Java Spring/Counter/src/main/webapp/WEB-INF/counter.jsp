<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Counter Page</title>
</head>
<body>
	<h2>You have visited "http://localhost:8080/your_server" ${count} times.</h2>
	<h2><a href="http://localhost:8080/your_server">Test another visit?</a></h2>
	<h2>You have visited ""http://localhost:8080/your_server/counter/counter2" ${count2}/2 times.</h2>
	<h2><a href="http://localhost:8080/your_server/counter/counter2">Test another visit?</a></h2>
	<a href="http://localhost:8080/your_server/counter/reset"><button class="btn btn-outline-primary" >reset the count</button></a>
</body>
</html>