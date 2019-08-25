<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Expression Language</title>
</head>
<body>
	<div class="container">
			<table class="table table-bordered table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<td colspan="2"><h4>Arithmetic Operators</h4></td>
						<td colspan="2"><h4>Relations Operators</h4></td>
					<tr>
						<th>Expression</th>
						<th>Results</th>
						<th>Expression</th>
						<th>Results</th>
					</tr>

					<tr>
						<td><span>$</span>{3+2-1}</td>
						<td>${3+2-1}</td>
						<td><span>$</span>{1<2}</td>
						<td>${1<2}</td>
					</tr>
					<tr>
						<td><span>$</span>{"1"+2}</td>
						<td>${"1"+2}</td>
						<td><span>$</span>{"a" < "b"}</td>
						<td>${"a" < "b"}</td>
					</tr>
					<tr>
						<td><span>$</span>{1+2*3+3/4}</td>
						<td>${1+2*3+3/4}</td>
						<td><span>$</span>{2/3 >= 3/2}</td>
						<td>${2/3 >= 3/2}</td>
					</tr>
					<tr>
						<td><span>$</span>{3%2}</td>
						<td>${3%2}</td>
						<td><span>$</span>{3/4 == 0.75}</td>
						<td>${3/4 == 0.75}</td>
					</tr>

					<tr>
						<td><span>$</span>{(8 div 2) mod 3}</td>
						<td>${(8 div 2) mod 3}</td>
						<td><span>$</span>{null == "test"}</td>
						<td>${null == "test"}</td>
					</tr>
					<tr>
						<td colspan="2"><h4>Logical Operators</h4></td>
						<td colspan="2"><h4>
								<span class="badge badge-pill badge-danger">empty </span>
								Operator
							</h4></td>
					<tr>
						<th>Expression</th>
						<th>Results</th>
						<th>Expression</th>
						<th>Results</th>
					</tr>
					<tr>
						<td><span>$</span>{(1<2)&&(4<3)}</td>
						<td>${(1<2)&&(4<3)}</td>
						<td><span>$</span>{empty ""}</td>
						<td>${empty ""}</td>
					</tr>
					<tr>
						<td><span>$</span>{(1<2)||(4<3)}</td>
						<td>${(1 < 2)||(4 < 3)}</td>
						<td><span>$</span>{empty null}</td>
						<td>${empty null}</td>
					</tr>
					<tr>
						<td><span>$</span>{!(1<2)}</td>
						<td>${!(1 < 2)}</td>
						<td><span>$</span>{empty param.blah}</td>
						<td>${empty param.blah}</td>

					</tr>
				</thead>

			</table>
		</div>
</body>
</html>