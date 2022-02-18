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
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja:</h1>
	<form:form action="/submitNinjaForm" method="post" modelAttribute="ninja">
	
	<p>
        <form:label path="dojo">Dojo:</form:label>
        <form:errors path="dojo"/>
        <form:select path="dojo">
        	<c:forEach var="d" items="${dojos}">
        	<option value="${d.id}">${d.dojoName}</option>
        	</c:forEach>
        </form:select>
    </p>
    <p>
        <form:label path="ninjaName">First Name:</form:label>
        <form:errors path="ninjaName"/>
        <form:input path="ninjaName"/>
    </p>
    <p>
        <form:label path="ninjaLastname">Last Name:</form:label>
        <form:errors path="ninjaLastname"/>
        <form:input path="ninjaLastname"/>
    </p>
     <p>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input path="age" type="number"/>
    </p>
     
    <input type="submit" value="Create"/>
	</form:form>

</body>
</html>