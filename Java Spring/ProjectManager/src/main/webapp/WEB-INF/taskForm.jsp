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
<title>Task Page</title>
</head>
<body>
	<h1>Project: ${project.projectName }</h1>
	<p>Project Lead: ${project.leader.userName }</p>

	<form:form action="/task/${project.id}" method="post" modelAttribute="task">
	
	
	<form:hidden path="creator" value="${project.leader.id}" />
	
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="datail">Add a task ticket for this team:</form:label>
        <div class="col-sm-10">
        	<form:textarea path="datail"/>
        	<form:errors path="datail"/>
         </div>
    </div>
	<input class="btn btn-dark" type="submit" value="Submit"/>
	</form:form>
	<c:forEach var="task" items="${tasks}">
	<h3>Add by ${task.creator.userName} at <fmt:formatDate value="${task.createdAt}" pattern="hh:mm a MMM d"/>:</h3>
	<h3>${task.datail}</h3>	
	</c:forEach>
</body>
</html>