<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Category</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>${category.name}</h1>
	<h4>Products in this category:</h4>
	<ul>
		<c:forEach items="${category.products}" var="product">
			<li><c:out value="${product.name}"/></li>
			</c:forEach>
	</ul>
	
	<h2>add product</h2>
	<form action="/categories/${category.id}/addprod" method="post">
		<select name="product_id">
			<c:forEach items="${products}" var="product">
				<option value="${product.id}"><c:out value="${product.name}"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Add"/>
	</form>
</body>
</html>