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

<style>
body {
	background: repeat rgba(235, 150, 108, 0.1);
}

.main {
	position: relative;
}

.wrap {
	margin: 20px auto;
	padding: 20px;
	position: relative;
	width: 300px;
}

.wrap p {
	margin: 0;
	padding: 0;
}

.wrap blockquote {
	margin: 0;
	padding: 0;
	position: relative;
}

.style-2 blockquote {
	padding-top: 150px;
}

.style-2 blockquote:after {
	background: none repeat scroll 0 0 rgba(235, 150, 108, 0.8);
	border-radius: 50% 50% 50% 50%;
	color: rgba(255, 255, 255, 0.5);
	content: "❞";
	font-family: 'icons';
	font-size: 70px;
	height: 130px;
	left: 50%;
	line-height: 130px;
	margin-left: -65px;
	position: absolute;
	text-align: center;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.1);
	top: 0;
	width: 130px;
}

.style-2 blockquote:before {
	border-left: 5px solid rgba(235, 150, 108, 0.1);
	border-radius: 50% 50% 50% 50%;
	content: "";
	height: 500px;
	left: -50px;
	position: absolute;
	top: 0;
	width: 500px;
	z-index: -1;
}

.style-2 blockquote p {
	background: none repeat scroll 0 0 rgba(255, 255, 255, 0.5);
	box-shadow: 0 -6px 0 rgba(235, 150, 108, 0.2);
	color: rgba(235, 150, 108, 0.8);
	display: inline;
	font-family: Baskerville, Georgia, serif;
	font-style: italic;
	font-size: 28px;
	line-height: 46px;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.5);
}

.attribution {
	text-align: center;
}

.author {
	color: #D48158;
	font-size: 18px;
	font-weight: bold;
	padding-top: 10px;
	text-shadow: 0 1px 1px rgba(255, 255, 255, 0.1);
	text-transform: uppercase;
}
</style>
<meta charset="UTF-8">
<title>Some Inspiration</title>
</head>
<body>
<body>
	<c:choose>
		<c:when test="${quoteEntry.quote eq NULL}">
			<h2>No quotes to display</h2>
			<a href="admin" class="btn btn-outline-primary"> Administration
				Page</a>
		</c:when>

		<c:otherwise>
			<a href="admin" class="btn btn-outline-primary"> Administration
				Page</a>
			<a href="inspire" class="btn btn-outline-success"> Inspire me
				more!</a>
			<section class="main">
				<div class="wrap style-2">
					<blockquote>
						<p>
							<c:out value="${quoteEntry.quote}" />
						</p>
					</blockquote>
				</div>

				<div class="attribution">
					<p class="author">
						<c:out value="${quoteEntry.author}" />
					</p>
				</div>

			</section>
		</c:otherwise>
	</c:choose>
</body>
</body>
</html>