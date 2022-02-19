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
<title>Book Details</title>
</head>
<body>
	<div class="header2">
		<div >
			<h1>${book.bookName}</h1>
		</div>
		<div class="link">
			<p><a href="/logout">logout</a></p>
			<p><a href="/dashboard">Back to the shelves</a></p>
		</div>
	</div>
		<c:choose>
    		<c:when test="${userId==book.reader.id}">
        		<h2><span class="red">You</span> read <span class="purple">${book.bookName}</span> by <span class="green">${book.author}</span></h2>
    	</c:when>    
    	<c:otherwise>
       		 <h2><span class="red">${book.reader.userName}</span> read <span class="purple">${book.bookName}</span> by <span class="green">${book.author}</span></h2>	
    	</c:otherwise>
		</c:choose>
	
		<c:choose>
    		<c:when test="${userId==book.reader.id}">
        	<h3>Here are your thoughts:</h3>
    	</c:when>    
    	<c:otherwise>
       		 <h3>Here are ${ book.reader.userName }'s thoughts:</h3>
    	</c:otherwise>
		</c:choose>
	<hr>
	<div class="box">
		
		<h4>${book.thoughts}</h4>
		
	</div>
	<hr>
	
	<c:choose>
    		<c:when test="${userId==book.reader.id}">
        	<a href="/books/edit/${book.id }" class="btn btn-dark">Edit</a>
    	</c:when>    
	</c:choose>

	
</body>
</html>