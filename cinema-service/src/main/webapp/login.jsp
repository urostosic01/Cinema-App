<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="${loginUrl}" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="username" placeholder="" required></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" placeholder=""
					required></td>
			</tr>

			<tr>
				<td><input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /></td>
				<td><button type="submit">Login</button></td>
			</tr>
		</table>
	</form>
</body>
</html>