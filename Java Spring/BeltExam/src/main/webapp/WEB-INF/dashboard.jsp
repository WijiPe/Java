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
<title>Dashboard</title>
</head>
<body>
	<div class="header2">
		<h1>Welcome, ${user.userName}</h1>
		<p><a href="/logout">log out</a></p>
	</div>
	<div class="header2">
		<h3>TV Shows</h3>
	</div>
	<table class="table">
		<thead>
    		<tr>
    			<th scope="col">Show</th>
      			<th scope="col">Network</th>
      			<th scope="col">Rating Average</th>                                          
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="show" items="${shows}">
    		<tr  class="table-light">
      			<td><a href="/show/details/${show.id}"><c:out value = "${show.title}"/></a></td>
      			<td><c:out value="${show.network}"/></td>
      				<c:forEach var="rating" items="${show.rating}">
      				<td>${rating.rate}</td>
      				</c:forEach>
    		</tr>
    		</c:forEach>
  		</tbody>
  	</table>
  	<a href="/show/new" class="btn btn-dark">Add a show</a>
</body>
</html>