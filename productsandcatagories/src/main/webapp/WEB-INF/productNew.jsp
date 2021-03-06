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
	<h1>New Product</h1>
	<form:form action="/products/create" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name: </form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>
			<form:label path="description">Description: </form:label>
			<form:errors path="description"/>
			<form:textarea path="description"/>
		</p>
		<p>
			<form:label path="price">Price: </form:label>
			<form:errors path="price"/>
			<form:input path="price"/>
		</p>
		<input type="submit" value="Create"/>
	</form:form>
	
</body>
</html>