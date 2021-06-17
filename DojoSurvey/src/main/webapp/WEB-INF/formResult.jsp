<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Results</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>Survey Results</h1>
		<p>Your Name: <c:out value="${fullName}"/></p>
		<p>Dojo Location: <c:out value="${dojoLocation}"/></p>
		<p>Favorite Language: <c:out value="${favLanguage}"/></p>
		<p>Comments: <c:out value="${comments}"/></p>
	</div>
</body>
</html>