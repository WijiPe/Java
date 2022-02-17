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
<title>Top Ten Songs</title>
</head>
<body>
	<h1>Top Ten Songs:</h1>
	<h4><a href="/songs" >Dashboard</a></h4>
	<table class="table">
		<thead>
    		<tr>
      			<th scope="col">Rating</th>
      			<th scope="col">Title</th>
      			<th scope="col">Artist</th>
      			<th scope="col"></th>
    		</tr>
  		</thead>
		<tbody>
  			<c:forEach var="s" items="${songs}">
    			<tr  class="table-light">
      				<td>${s.rating}</td>
      				<td>${s.title}</td>
      				<td>${s.artist}</td>
      				<td>
      			</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
</body>
</html>