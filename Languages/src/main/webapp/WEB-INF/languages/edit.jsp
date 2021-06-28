<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Language</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<form:form action="/languages/${lang.id}/update" method="post" modelAttribute="lang">
	
	
	<p>
		<form:label path="name">Name: </form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</p>
	<p>
		<form:label path="creator">Creator: </form:label>
		<form:errors path="creator"/>
		<form:input path="creator" value="${lang.creator}"/>
	</p>
	<p>
		<form:label path="currentVersion">Current Version: </form:label>
		<form:errors path="currentVersion"/>
		<form:input path="currentVersion" value="${lang.currentVersion}"/>
	</p>
	
	<input type="submit" value="Update"/>
	</form:form>
</body>
</html>