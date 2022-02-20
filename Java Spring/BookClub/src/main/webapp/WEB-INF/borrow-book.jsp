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
<title>Book Lender Dashboard</title>
</head>
<body>
	<div class="header2">
		<div >
			<h2>Welcome, ${user.userName} </h2>
			<h1>The Book Broker!</h1>
		</div>
		<div class="link">
			<p><a href="/logout">logout</a></p>
			<p><a href="/books/new">+ Add a book to my shelf!</a></p>
		</div>
	</div>
	<h2>Available Books to Borrow</h2>
	<table class="table">
  		<thead>
    		<tr>
    			<th scope="col">ID</th>
      			<th scope="col">Title</th>
      			<th scope="col">Author Name</th>
      			<th scope="col">Owner</th>
      			<th scope="col">Actions</th>                                          
    		</tr>
  		</thead>
		<tbody>
  		<c:forEach var="book" items="${books}">
    		<tr class="table-light">
      			<td><c:out value = "${book.id}"/></td>
      			<td><a href="/books/${book.id}"><c:out value = "${book.bookName}"/></a></td>
      			<td><c:out value="${book.author}"/></td>
      			<td><c:out value="${book.reader.userName}"/></td>
      			<td>
      			<c:choose>
    			<c:when test="${userId==book.reader.id}">
    				<div class="deletebtn" >
    					<a href="/books/edit/${book.id}">edit</a>|
        				<form  action="/books/delete/${book.id}" method="post">
        					<input type="hidden" name="_method" value="delete" />
        					<button class="btn btn-link">delete</button>
        				</form>
    				</div>
    			</c:when>    
    			<c:otherwise>
       		 		<a href="/books/borrow/${book.id}">borrow</a>
    			</c:otherwise>
				</c:choose>
      			</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
	<h2>Books I'm Borrowing..</h2>
	<table class="table">
  		<thead>
    		<tr>
    			<th scope="col">ID</th>
      			<th scope="col">Title</th>
      			<th scope="col">Author Name</th>
      			<th scope="col">Owner</th>
      			<th scope="col">Actions</th>                                          
    		</tr>
  		</thead>
		<tbody>
  		<c:forEach var="book" items="${bookNotBorrows}">
    		<tr  class="table-light">
      			<td><c:out value = "${book.id}"/></td>
      			<td><a href="/books/${book.id}"><c:out value = "${book.bookName}"/></a></td>
      			<td><c:out value="${book.author}"/></td>
      			<td><c:out value="${book.reader.userName}"/></td>
      			<td><a href="/books/return/${book.id}">return</a></td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>

</body>
</html>