<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
</head>
<body>
	<h2>Hello, Admin</h2>
	<form action="/logout" method="POST">
		<input type="submit" value="LogOut"> <input type="hidden"
			name="${_csrf.parameterName}" value="${_csrf.token}" />

	</form>
</body>
</html>