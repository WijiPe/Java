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
    		</tr>
  		</thead>
  		<tbody>
  		<c:forEach var="expense" items="${expenses}">
    		<tr  class="table-light">
      			<td>${expense.expense}</td>
      			<td>${expense.vendor}</td>
      			<td><fmt:formatNumber type="CURRENCY" value="${expense.amount}"/></td>
    		</tr>
    	</c:forEach>
  		</tbody>
	</table>
	<h2>Add an expense:</h2>
	<form:form action="/submitForm" method="post" modelAttribute="expense">
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
        <form:input type="number" step="0.01" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>     
        <form:textarea path="description"></form:textarea>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>