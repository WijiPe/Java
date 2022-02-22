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
<title>Edit Form</title>
</head>
<body>
	<h1>Edit a Project</h1>
	<form:form action="/projects/edit/${project.id }" method="post" modelAttribute="project">
	<input type="hidden" name="_method" value="put" />
	
	<form:hidden path="leader" value="${userId}" />
	
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="projectName">Project Title:</form:label>
        <div class="col-sm-10">
        	<form:input path="projectName"/>
        	<form:errors path="projectName"/>
         </div>
    </div>
   <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="description">Project Description:</form:label>
        <div class="col-sm-10">
        	<form:textarea path="description"/>
        	<form:errors path="description"/>
        </div>
    </div>
     <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="dueDate">Due Date:</form:label>
        <div class="col-sm-10">
        	<form:input path="dueDate" type="date" min="2021-02-22" max="2030-02-31"/>
        	<form:errors  path="dueDate"/>
        </div>
    </div>

	<input class="btn btn-dark" type="submit" value="Submit"/>
	</form:form>	
</body>
</html>