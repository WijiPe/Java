<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>${language.name}</h2>
	<h2>${language.creator}</h2>
	<h2>${language.version}</h2>
	<h2><a href="/languages/edit/${language.id}">edit</a></h2>
	<form action="/languages/delete/${language.id}" method="post">
      	<input type="hidden" name="_method" value="delete" />
      	<button> Delete </button>
     </form>
</body>
</html>