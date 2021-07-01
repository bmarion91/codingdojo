<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>${product.name}</h1>
	<h3>${product.description}</h3>
	
	<h4>categories:</h4>
	<ul>
	<c:forEach items="${product.categories}" var="category">
		<li><c:out value="${category.name}"/></li>
	</c:forEach>
	</ul>
	<h2>add to category</h2>
	<form action="/products/${product.id}/addcat" method="post">
		<select name="category_id">
		<c:forEach items="${categories}" var="category">
			<option value="${category.id}"><c:out value="${category.name}"/></option>
		</c:forEach>
		</select>
		<input type="submit" value="Add"/>
	</form>
	
	
</body>
</html>