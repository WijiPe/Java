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
<link rel="stylesheet" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Dashboard</title>
</head>
<body>
	<div class="header2">
		<div >
			<h1>Welcome, ${user.userName} </h1>
			<p>Books from everyone's shelves:</p>
		</div>
		<div class="link">
			<p><a href="/logout">logout</a></p>
			<p><a href="/books/new">+ Add a book to my shelf!</a></p>
			<p><a href="/lender_dashboard">Book Broker</a></p>
		</div>
	</div>
		<table class="table">
  		<thead>
    		<tr>
    			<th scope="col">ID</th>
      			<th scope="col">Title</th>
      			<th scope="col">Author Name</th>
      			<th scope="col">Posted By</th>                                             
    		</tr>
  		</thead>
		<tbody>
  		<c:forEach var="book" items="${books}">
    		<tr  class="table-light">
      			<td><c:out value = "${book.id}"/></td>
      			<td><a href="/books/${book.id}"><c:out value = "${book.bookName}"/></a></td>
      			<td><c:out value="${book.author}"/></td>
      			<td><c:out value="${book.reader.userName}"/></td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
</body>
</html>