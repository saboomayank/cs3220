<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<style>
body {
	padding-top: 5%;
}
</style>
<meta charset="UTF-8">
<title>Add Quotes</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-md-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<form accept-charset="UTF-8" action="AddController" method="POST">
							Author: <input type="text" name="author" placeholder = "Enter author name"/> <br> <br>
							Quote:
							<textarea class="form-control counted" name="quote"
								placeholder="Type in the quote" rows="5"
								style="margin-bottom: 10px;"></textarea>

							<button class="btn btn-info" type="submit" name="add" value="add">Add
								Quote</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>