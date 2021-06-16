<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Home page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

	<p> You have visited <a href="/my_server">/my_server</a> <c:out value="${count}"/> times</p>
	<p><a href="/my_server">test another visit?</a></p>
</body>
</html>