<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<title>Home</title>
</head>
<body>
<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">Name</th>
      			<th scope="col">Creator</th>
      			<th scope="col">Version</th>
      			<th scope="col">action</th>
      			<th scope="col"></th>
    		</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="l" items="${languages}">
    		<tr  class="table-light">
      			<td><a href="/lanuages/${l.id}">${l.name}</a></td>
      			<td>${l.creator}</td>
      			<td>${l.version}</td>
      			<td><a href="/lanuages/edit/${l.id}">edit</a></td>
      			<td>
      				<form action="/languages/delete/${l.id}" method="post">
      					<input type="hidden" name="_method" value="delete" />
      					<button> Delete </button>
      				</form>
      			</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
	<form:form action="/submitForm" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator:</form:label>
        <form:errors path="creator"/>
        <form:input path="creator"/>
    </p>
    <p>
        <form:label path="version">Version:</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>  
    <input type="submit" value="Submit"/>
	</form:form>

</body>
</html>