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
<title>Edit</title>
</head>
<body>
	<h1><c:out value="${show.title }"/></h1>
	<form:form action="/show/edit/${show.id }" method="post" modelAttribute="show">
	<input type="hidden" name="_method" value="put" />
	
	
	<form:hidden path="user" value="${userId}" />
	
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="title">Title:</form:label>
        <div class="col-sm-10">
        	<form:input path="title"/>
        	<form:errors path="title"/>
         </div>
    </div>
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="network">Network:</form:label>
        <div class="col-sm-10">
        	<form:input path="network"/>
        	<form:errors path="network"/>
        </div>
    </div>
   <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="description">Description:</form:label>
        <div class="col-sm-10">
        	<form:textarea path="description"/>
        	<form:errors path="description"/>
        </div>
    </div>

	<input class="btn btn-dark" type="submit" value="Submit"/>
	</form:form>
	<a href="/dashboard" class="btn btn-dark">Cancel</a>
	<form action="/show/delete/${show.id }" method="post">
		<input type="hidden" name="_method" value="delete" />
		<button class="btn btn-danger">Delete Show</button>
	</form>
</body>
</html>