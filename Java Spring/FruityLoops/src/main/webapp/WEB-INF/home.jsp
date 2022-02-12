<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Fruit Loops Display</title>
</head>
<body>
	
	<div class="box">
	<h1>Fruit Store</h1>
  		<table class="table">
  			<thead>
    			<tr>
      				<th scope="col">Name</th>
      				<th scope="col">Price</th>
    			</tr>
  			</thead>
  	
  			<tbody>
  			<c:forEach var="fruits" items="${fruits}">
  				<tr class="table-primary">
      				<td>${fruits.name}</td>
      				<td>${fruits.price}</td>
				</tr>
			</c:forEach>
    		</tbody>
  		</table>
    </div>
</body>
</html>