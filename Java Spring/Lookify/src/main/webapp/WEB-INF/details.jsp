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
<title>Song Details</title>
</head>
<body>
	<h4><a href="/songs" >Dashboard</a></h4>
	<h3>Title: ${song.title} </h3>
	<h3>Artist: ${song.artist}</h3>
	<h3>Rating(1-10): ${song.rating}</h3>
	<form action="/songs/delete/${song.id}" method="post">
      	<input type="hidden" name="_method" value="delete" />
      	<button> Delete </button>
    </form>
</body>
</html>