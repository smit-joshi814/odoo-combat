<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Form</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2>User Form</h2>
		<form action="/submitUserForm" method="POST">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" required>
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" id="email" name="email" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" name="password" required>
			</div>
			<div class="form-group">
				<label for="phoneNumber">Phone Number:</label> <input type="tel"
					class="form-control" id="phoneNumber" name="phoneNumber" required>
			</div>
			<div class="form-group">
				<label for="role">Role:</label> <select class="form-control"
					id="role" name="role" required>
					<option value="USER">User</option>
					<option value="ADMIN">Admin</option>
					<!-- Add other roles here -->
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
