<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Project Details</title>
</head>
<body>
	<h1>Project Details</h1>
	<ul class="list-group">
  		<li class="list-group-item list-group-item-action">
  		<p>Project: <c:out value="${project.projectName }"/></p>
  		</li>
  		<li class="list-group-item list-group-item-action">  		
  		<p>Description: <c:out value="${project.description }"/></p>
  		</li>
  		<li class="list-group-item list-group-item-action">  		
  		<p>Due Date: <fmt:formatDate value="${project.dueDate}" pattern="MMMM d"/></p>
  		</li>
	</ul>
	<a href="/task/${project.id}">See tasks!</a>
</body>
</html>