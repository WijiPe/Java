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
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Form</title>
</head>
<body>
	<div class="header2">
			<h1>Add a Book to Your Shelf!:</h1>
		<div class="link">
			<p><a href="/logout">logout</a></p>
			<p><a href="/dashboard">back to the shelves!</a></p>
		</div>
	</div>
	
	<form:form action="/submitForm" method="post" modelAttribute="book">
	
	
	<form:hidden path="reader" value="${userId}" />
	
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="bookName">Title:</form:label>
        <div class="col-sm-10">
        	<form:input path="bookName"/>
        	<form:errors path="bookName"/>
         </div>
    </div>
   <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="author">Author:</form:label>
        <div class="col-sm-10">
        	<form:input path="author"/>
        	<form:errors path="author"/>
        </div>
    </div>
     <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="thoughts">My Thoughts</form:label>
        <div class="col-sm-10">
        	<form:textarea rows="10" cols="23" path="thoughts"/>
        	<form:errors path="thoughts"/>
        </div>
    </div>

	<input class="btn btn-dark" type="submit" value="Submit"/>
	</form:form>

</body>
</html>