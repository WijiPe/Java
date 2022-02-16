<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<title>Display Books Table</title>
</head>
<body>
	<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">ID</th>
      			<th scope="col">Title</th>
      			<th scope="col">Language</th>
     		 	<th scope="col">Pages</th>
    		</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="book" items="${books}">
    		<tr  class="table-light">
      			<td>${book.getId()}</td>
      			<td><a href="/books/${book.id}" >${book.title}</a></td>
      			<td>${book.description}</td>
      			<td>${book.language}</td>
      			<td>${book.numberOfPages}</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
</body>
</html>