<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
</head>
<body>
	<h2>Expense Details:</h2><a href="/expenses">Go Back</a>
	<h3>Expense Name:${expenseModel.expense}</h3>
	<h3>Expense Description:${expenseModel.description}</h3>
	<h3>Vendor:${expenseModel.vendor}</h3>
	<h3>Amount Spent:${expenseModel.amount}</h3>
</body>
</html>