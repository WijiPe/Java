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
<title>Display</title>
</head>
<body>
	<h1>${dormitory.name}</h1>
	<form action="/submitStudentinDormForm/${dormitory.id} " method="post">
	<input type="hidden" name="_method" value="put"/>
	<p>
        <label for="studentId">Students:</label>
        <select name="studentId" id="studentId">
        	<c:forEach var="s" items="${students}">
        		<option value="${s.id}">${s.name}</option>
        	</c:forEach>
        </select>
    </p>
    
     <input type="submit" value="Add"/>
	</form>
	<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">Name</th>
      			<th scope="col">Action</th>
    		</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="d" items="${dormitory.students}">
    		<tr  class="table-light">
      			<td>${d.name}</td>
      			<td>
      			<form action="/student/delete/${d.id}" method="post">
      				<input type="hidden" name="_method" value="put" />
      				<button>Remove</button>
      			</form>
				</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
</body>
</html>