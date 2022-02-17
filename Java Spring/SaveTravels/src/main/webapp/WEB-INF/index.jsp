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
<title>Home Page</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table class="table">
  		<thead>
    		<tr>
      			<th scope="col">Expense</th>
      			<th scope="col">Vendor</th>
      			<th scope="col">Amount</th>
      			<th scope="col">Actions</th>
      			<th scope="col"></th>
    		</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="e" items="${expenses}">
    		<tr  class="table-light">
      			<td>${e.expense}</td>
      			<td>${e.vendor}</td>
      			<td><fmt:formatNumber type="CURRENCY" value="${e.amount}"/></td>
      			<td><a href="/expenses/edit/${e.id}">edit</a></td>
      			<td>
      			<form action="/expenses/delete/${e.id}" method="post">
      			<input type="hidden" name="_method" value="delete" />
      			<button> Delete </button>
      			</form>
      			</td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
	<h2>Add an expense:</h2>
	<form:form action="/submitForm" method="post" modelAttribute="expenseModel">
    <p>
        <form:label path="expense">Expense Name:</form:label>
        <form:errors path="expense"/>
        <form:input path="expense"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
    </p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>     
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
	</form:form>
	
</body>
</html>