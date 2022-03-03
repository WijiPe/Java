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
<title>Show Details</title>
</head>
<body>
	<div class="header2">
	<h1><c:out value="${show.title}"/></h1>
	<a href="/dashboard">Back to Dashboard</a>
	</div>
	<ul class="list-group">
  		<li class="list-group-item list-group-item-action">
  		<p>Posted by: <c:out value="${show.user.userName}"/></p>
  		</li>
  		<li class="list-group-item list-group-item-action">  		
  		<p>Network: <c:out value="${show.network}"/></p>
  		</li>
  		<li class="list-group-item list-group-item-action">  		
  		<p>Description: <c:out value="${show.description}"/></p>
  		</li>
	</ul>
			<c:choose>
    			<c:when test="${userId==show.user.id}">
    				<div class="deletebtn" >
    					<a href="/show/edit/${show.id}" class="btn btn-dark">Edit</a>
    				</div>
    			</c:when>    
			</c:choose>
	<hr>
	
	<table class="table">
		<thead>
    		<tr>
    			<th scope="col">Name</th>
      			<th scope="col">Rating</th>                                         
    		</tr>
  		</thead>
  		<tbody>
  			<c:forEach var="rating" items="${ratings}">
    		<tr  class="table-light">
      			<td><c:out value = "${rating.user_who_rate.userName}"/></td>
      			<td><c:out value="${rating.rate}"/></td>
    		</tr>
    		</c:forEach>
  		</tbody>
  	</table>
  	
  	<form:form action="/submitRatingForm/${show.id}" method="post" modelAttribute="rating">
	
	<form:hidden path="user_who_rate" value="${userId}" />
	<form:hidden path="show" value="${show.id}" />
	
    <div class="row mb-3">
        <form:label class="col-sm-2 col-form-label" path="rate">Leave a Rating:</form:label>
        <div class="col-sm-10">
        	<form:input path="rate" type="number" step="1.0"/>
        	<form:errors path="rate"/>
         </div>
    </div>
   
	<input class="btn btn-dark" type="submit" value="Rate!"/>
	</form:form>
	
</body>
</html>