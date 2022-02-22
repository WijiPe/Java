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
			<h1>Welcome, ${user.userName} </h1>
			<p><a href="/logout">logout</a></p>
	</div>
	<div class="header2">
		<h2>All Projects</h2>
		<p><a href="/project/new">+ new project</a></p>
	</div>
	<table class="table">
  		<thead>
    		<tr>
    			<th scope="col">Project</th>
      			<th scope="col">Team Lead</th>
      			<th scope="col">Due Date</th>
      			<th scope="col">Actions</th>                                          
    		</tr>
  		</thead>
		<tbody>
  		<c:forEach var="project" items="${notYourProjects}">
    		<tr  class="table-light">
      			<td><a href="/projects/details/${project.id}"><c:out value = "${project.projectName}"/></a></td>
      			<td><c:out value="${project.leader.userName}"/></td>
      			<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM d"/></td>
      			<td><a href="/jointeam/${project.id}">Join Team</a></td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
	<h2>Your Project</h2>
	<table class="table">
  		<thead>
    		<tr>
    			<th scope="col">Project</th>
      			<th scope="col">Lead</th>
      			<th scope="col">Due Date</th>
      			<th scope="col">Actions</th>                                           
    		</tr>
  		</thead>

  		<tbody>
  		<c:forEach var="project" items="${yourProjects}">
    		<tr class="table-light">
    			<td><a href="/projects/details/${project.id}"><c:out value = "${project.projectName}"/></a></td>
      			<td><c:out value="${project.leader.userName}"/></td> 
      			<td><fmt:formatDate value="${project.dueDate}" pattern="MMMM d"/></td>
      			<td>
      			<c:choose>
    			<c:when test="${userId==project.leader.id}">
    				<div class="deletebtn" >
    					<a href="/projects/edit/${project.id}">edit</a>
    				</div>
    			</c:when>    
    			<c:otherwise>
       		 		<a href="/leaveteam/${project.id}">Leave Team</a>
    			</c:otherwise>
				</c:choose>
      			</td>
    		</tr>
    	</c:forEach>
  		</tbody>
		
	</table>
</body>
</html>