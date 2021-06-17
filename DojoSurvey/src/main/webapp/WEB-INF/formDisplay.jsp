<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Survey Form</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
 <div>
 	<form class="col-sm survey" action="/result" method="POST">
 		<div class="form-group">
 			<label for="fullName">Your Name: </label><input type="text" name="fullName">
 		</div>
		<div class="form-group">
			<label for="dojoLocation">Dojo Location</label>
			<select name="dojoLocation">
			<option value="San Jose">San Jose</option>
			<option value="Burbank">Burbank</option>
			</select>
		</div>
		<div class="form-group">
			<label for="favLanguage">Favorite Language</label>
			<select name="favLanguage">
			<option value="java">Java</option>
			<option value="python">Python</option>
			<option value="mern">MERN</option>
			</select>
		</div>
 			<label for="comments">Optional Comments</label>
 			<textarea name="comments" rows="5" cols="10"></textarea>
 		<button type="submit" class="btn btn-primary">Submit</button>
 	</form>
 </div>
</body>
</html>