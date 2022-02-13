<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<title>Home Page</title>
</head>
<body>
	<h1 class="head">Send an Omikuji!</h1>
	<div class="formContainer">
    	<form class ="form" action='/submitForm' method='POST'>
			<label>Pick any number from 5 to 25</label>
			<select name="number">
				<option value="">--Please choose an option--</option>
    			<option value="5">5</option>
    			<option value="6">6</option>
    			<option value="7">7</option>
    			<option value="8">8</option>
    			<option value="9">9</option>
    			<option value="10">10</option>
    			<option value="11">11</option>
    			<option value="12">12</option>
    			<option value="13">13</option>
    			<option value="14">14</option>
    			<option value="15">15</option>
    			<option value="16">16</option>
    			<option value="17">17</option>
    			<option value="18">18</option>
    			<option value="19">19</option>
    			<option value="20">20</option>
    			<option value="21">21</option>
    			<option value="22">22</option>
    			<option value="23">23</option>
    			<option value="24">24</option>
    			<option value="25">25</option>
			</select>
			<label>Enter the name of any city </label>
    		<input type="text" name='city'>
			<label>Enter the name of any real person</label>
    		<input type='text' name='famousName'>
			<label>Enter professional endeavor or hobby</label>
    		<input type='text' name='hobby'>
			<label>Enter any type of living thing</label>
    		<input type='text' name='somethingLiving'>
			<label>Say something nice to someone</label>
    		<input type='text' name='quote'>  
    		<label>Send and show a friend</label> 	    	
    		<input type='submit' value='login'>
    	</form>
    </div>

	

</body>
</html>