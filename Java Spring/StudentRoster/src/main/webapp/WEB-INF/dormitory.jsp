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
<title>Dormitory</title>
</head>
<body>
	<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">Name</th>
    		</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="d" items="${dormitories}">
    		<tr  class="table-light">
      			<td><a href="/dormitory/${d.id}">${d.name}</a></td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>

</body>
</html>