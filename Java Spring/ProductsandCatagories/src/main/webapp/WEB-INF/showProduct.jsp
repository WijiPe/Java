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
<title>Product Page</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<h2>Categories:</h2>
	<ul class="list-group">
		<c:forEach var="category" items="${product.catagories}">
			<li class="list-group-item list-group-item-primary"><c:out value="${category.name}"/></li>
		</c:forEach>
	</ul>
	<form action="/products/${product.id} " method="post">
	<input type="hidden" name="_method" value="put"/>
		<label for="categoryId">Add Category:</label>
        <select name="categoryId">
        	<c:forEach var="category" items="${categories}">
        		<option value="${category.id}">${category.name}</option>
        	</c:forEach>
        </select>
        <input type="submit" value="Add"/>
	</form>
</body>
</html>