<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Admin</title>
</head>
<body>
	<c:if test="${fn:length(quoteBookEntries) == 0 }">
		<h2>No quotes to display</h2>
	</c:if>
	<c:if test="${fn:length(quoteBookEntries) > 0 }">
		<table>
			<tr>
				<th>id</th>
				<th>quote</th>
				<th>author</th>
			</tr>
			<c:forEach items="${quoteBookEntries }" var="entry" varStatus="status">
				<tr>
					<td><c:out value="${entry.id}" /></td>
					<td><c:out value="${entry.quote}" /></td>
					<td><c:out value="${entry.author}" /></td>
					<td><a href="DeleteController?id=${entry.id}" class = "btnbtn-outline-warning">
							Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<a href="AddController" class="btn btn-outline-primary"> Add Quote</a>
	<a href="inspire" class="btn btn-outline-success">Inspire</a>
</body>
</html>