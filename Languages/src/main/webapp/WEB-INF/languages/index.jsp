<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Coding Languages Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${languages}" var="language">
			<tr>
				<td><a href="/languages/{language.id}"><c:out value="${language.name}"/></a></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.currentVersion}"/></td>
				<td><a href="/languages/${language.id}/edit">Edit</a> <a href="/languages/${language.id}/delete">Delete</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<form:form action="/languages/new" method="post" modelAttribute="language">
	<p>
		<form:label path="name">Name: </form:label>
		<form:errors path="name"/>
		<form:input path="name"/>
	</p>
	<p>
		<form:label path="creator">Creator: </form:label>
		<form:errors path="creator"/>
		<form:input path="creator"/>
	</p>
	<p>
		<form:label path="currentVersion">Current Version: </form:label>
		<form:errors path="currentVersion"/>
		<form:input path="currentVersion"/>
	</p>
	<input type="submit" value="Create"/>
	</form:form>
</body>
</html>