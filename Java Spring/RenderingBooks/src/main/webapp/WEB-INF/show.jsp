<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Page</title>
</head>
<body>
	<h1> ${book.title}</h1>
	
	<h2>Description : ${book.description}</h2>
	<h2>Language: ${book.language}</h2>
	<h2>Number of Pages : ${book.numberOfPages}</h2>
</body>
</html>