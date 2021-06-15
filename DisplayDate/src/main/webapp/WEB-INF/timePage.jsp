<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="JS/time.js"></script>
<link rel="stylesheet" href="CSS/timeStyle.css"/>
<title>time</title>
</head>
<body onLoad="showAlert()">
	<h1><fmt:formatDate pattern = "hh':'mm aa" value = "${time}" /></h1>
</body>
</html>