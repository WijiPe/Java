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
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form action="/submitForm" method="post" modelAttribute="product">
	
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="name">Name:</form:label>
        <div class="col-sm-10">
        	<form:input path="name"/>
        	<form:errors path="name"/>
         </div>
    </div>
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="description">Description:</form:label>
        <div class="col-sm-10">
        	<form:input path="description"/>
        	<form:errors path="description"/>
         </div>
    </div>
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="price">Price:</form:label>
        <div class="col-sm-10">
        	<form:input path="price" type="number"/>
        	<form:errors path="price"/>
         </div>
    </div>
    
	<input type="submit" value="Create"/>
	</form:form>
</body>
</html>