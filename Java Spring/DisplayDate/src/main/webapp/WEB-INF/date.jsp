<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Date</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h2 class="date"><fmt:formatDate value="${date}" pattern="EEEE', the 'd' of 'MMMM', 'yyyy"/></h2>
	<script type="text/javascript" src="/js/script.js"></script>
</body>
</html>