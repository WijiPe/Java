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
<title>Dojo</title>
</head>
<body>
	<h1>${dojo.dojoName} Location Ninjas</h1>
	<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">First Name</th>
      			<th scope="col">Last Name</th>
      			<th scope="col">Age</th>                                             
    		</tr>
  		</thead>
		<tbody>
  		<c:forEach var="ninja" items="${dojo.ninjas}">
    		<tr  class="table-light">
      			<td>${ninja.ninjaName}</td>
      			<td>${ninja.ninjaLastname}</td>
      			<td>${ninja.age}</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
</body>
</html>