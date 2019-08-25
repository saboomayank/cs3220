<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
	background-color: #E7E5E4 !important;
	position: relative;
	display: flex;
	justify-content: center;
}

td {
	border: 4px solid #888;
	height: 120px;
	min-width: 120px;
	text-align: center;
	vertical-align: middle;
	font-family: "Comic Sans MS", cursive, sans-serif;
	font-size: 40px;
	cursor: pointer;
}

table {
	border-collapse: collapse;
	margin: 0 auto;
	vertical-align: middle;
}

table tr:first-child td {
	border-top: none;
}

table tr:last-child td {
	border-bottom: none;
}

table tr td:first-child {
	border-left: none;
}

table tr td:last-child {
	border-right: none;
}

h1 {
	font-family: "Avant Garde", Avantgarde, "Century Gothic", CenturyGothic,
		"AppleGothic", sans-serif;
	font-size: 100px;
	padding: 50px 50px;
	text-align: center;
	text-transform: uppercase;
	text-rendering: optimizeLegibility;
	color: #131313;
	letter-spacing: .15em;
	text-shadow: 1px -1px 0 #767676, -1px 2px 1px #737272, -2px 4px 1px
		#767474, -3px 6px 1px #787777, -4px 8px 1px #7b7a7a, -5px 10px 1px
		#7f7d7d, -6px 12px 1px #828181, -7px 14px 1px #868585, -8px 16px 1px
		#8b8a89, -9px 18px 1px #8f8e8d, -10px 20px 1px #949392, -11px 22px 1px
		#999897, -12px 24px 1px #9e9c9c, -13px 26px 1px #a3a1a1, -14px 28px
		1px #a8a6a6, -15px 30px 1px #adabab, -16px 32px 1px #b2b1b0, -17px
		34px 1px #b7b6b5, -18px 36px 1px #bcbbba, -19px 38px 1px #c1bfbf,
		-20px 40px 1px #c6c4c4, -21px 42px 1px #cbc9c8, -22px 44px 1px #cfcdcd,
		-23px 46px 1px #d4d2d1, -24px 48px 1px #d8d6d5, -25px 50px 1px #dbdad9,
		-26px 52px 1px #dfdddc, -27px 54px 1px #e2e0df, -28px 56px 1px #e4e3e2;
}
</style>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>X's and O's</title>
</head>
<body>
	<div class="container">
		<h1 class="elegantshadow">Tic-Tac-Toe</h1>
		<c:choose>
			<c:when test="${ticTac.getWinnerWinnerChickenDinner() eq null }">
				<div class="text-center">
					<br>
					<h3>${ticTac.getPlayer()}'s Turn</h3>
					<br>
				</div>
				<table>
					<tr>
						<td><a href="PlayerController?loc=0">${ticTac.getMove(0)}</a>
						</td>
						<td><a href="PlayerController?loc=1">${ticTac.getMove(1)}</a>
						</td>
						<td><a href="PlayerController?loc=2">${ticTac.getMove(2)}</a>
						</td>
					</tr>
					<tr>
						<td><a href="PlayerController?loc=3">${ticTac.getMove(3)}</a>
						</td>
						<td><a href="PlayerController?loc=4">${ticTac.getMove(4)}</a>
						</td>
						<td><a href="PlayerController?loc=5">${ticTac.getMove(5)}</a>
						</td>
					</tr>
					<tr>
						<td><a href="PlayerController?loc=6">${ticTac.getMove(6)}</a>
						</td>
						<td><a href="PlayerController?loc=7">${ticTac.getMove(7)}</a>
						</td>
						<td><a href="PlayerController?loc=8">${ticTac.getMove(8)}</a>
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<c:choose>
					<c:when test="${ticTac.getWinnerWinnerChickenDinner() eq 'X'}">
						<div class="text-center">
							<h5>Player X has won the game!</h5>
							<button type="button" class="btn btn-outline-success">
								<a href="NewGameController">Still wanna play?</a>
							</button>
						</div>
					</c:when>
					<c:when test="${ticTac.getWinnerWinnerChickenDinner() eq 'O'}">
						<div class="text-center">
							<h5>Player O has won the game!</h5>
							<button type="button" class="btn btn-outline-success">
								<a href="NewGameController">Still wanna play?</a>
							</button>
						</div>
					</c:when>
					<c:when test="${ticTac.getWinnerWinnerChickenDinner() eq 'Draw'}">
						<div class="text-center">
							<h5>It's a draw. What are you doing? Focus!</h5>
							<button type="button" class="btn btn-outline-success">
								<a href="NewGameController">Still wanna play?</a>
							</button>
						</div>
					</c:when>
				</c:choose>
			</c:otherwise>
		</c:choose>

	</div>
</body>
</html>