<%@page import="com.odoo.combat.entities.Tasks"%>
<%@page import="com.odoo.combat.entities.SpecialPickup"%>
<%@page import="com.odoo.combat.entities.Reports"%>
<%@page import="com.odoo.combat.entities.Schedules"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
List<Schedules> schedules = (List<Schedules>) request.getAttribute("schedules");
List<Reports> reports = (List<Reports>) request.getAttribute("reports");
List<SpecialPickup> pickups = (List<SpecialPickup>) request.getAttribute("pickups");
List<Tasks> tasks = (List<Tasks>) request.getAttribute("tasks");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="#">Dashboard</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<form action="/logout" method="POST">
						<input type="submit" class="btn btn-danger" value="Logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</li>
			</ul>
		</div>

	</nav>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-12">
				<h2>Dashboard</h2>

				<div class="mb-5"></div>
				<!-- Report Table -->
				<h4>Reports</h4>
				<table class="table table-striped mb-5">
					<thead>
						<tr>
							<th>ID</th>
							<th>Description</th>
							<th>Photo URL</th>
							<th>Location</th>
							<th>User</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Reports report : reports) {
						%>
						<tr>
							<td><%=report.getReportId()%></td>
							<td><%=report.getDescription()%></td>
							<td><%=report.getLocation()%></td>
							<td><%=report.getUser().getName()%></td>
							<td><%=report.getStatus()%></td>
							<td></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<!-- Schedules Table -->
				<h4>Schedules</h4>
				<table class="table table-striped mb-5">
					<thead>
						<tr>
							<th>ID</th>
							<th>Day</th>
							<th>Time</th>
							<th>Area</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Schedules schedule : schedules) {
						%>
						<tr>
							<td><%=schedule.getScheduleId()%></td>
							<td><%=schedule.getDay()%></td>
							<td><%=schedule.getTime()%></td>
							<td><%=schedule.getArea()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<!-- Special Pickup Table -->
				<h4>Special Pickups</h4>
				<table class="table table-striped mb-5">
					<thead>
						<tr>
							<th>ID</th>
							<th>Description</th>
							<th>User</th>
							<th>Status</th>
							<th>Requested At</th>
							<th>Scheduled At</th>
							<th>Completed At</th>
							<th>Address</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (SpecialPickup pickup : pickups) {
						%>
						<tr>
							<td><%=pickup.getPickupId()%></td>
							<td><%=pickup.getDescription()%></td>
							<td><%=pickup.getUser().getName()%></td>
							<td><%=pickup.getStatus()%></td>
							<td><%=pickup.getRequestedAt()%></td>
							<td><%=pickup.getScheduledAt()%></td>
							<td><%=pickup.getCompletedAt()%></td>
							<td><%=pickup.getAddress().getAddressLine1()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<!-- Tasks Table -->
				<h4>Tasks</h4>
				<table class="table table-striped mb-5">
					<thead>
						<tr>
							<th>ID</th>
							<th>Report</th>
							<th>Collector</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Tasks task : tasks) {
						%>
						<tr>
							<td><%=task.getTaskId()%></td>
							<td><%=task.getReport().getDescription()%></td>
							<td><%=task.getCollector().getName()%></td>
							<td><%=task.getStatus()%></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>

				<!-- Form to Add Schedule -->
				<h4>Add Schedule</h4>
				<form action="add-schedule" class="mb-5" method="POST">
					<div class="form-group">
						<label for="day">Day:</label> <input type="text"
							class="form-control" id="day" name="day" required>
					</div>
					<div class="form-group">
						<label for="time">Time:</label> <input type="datetime-local"
							class="form-control" id="time" name="time" required>
					</div>
					<div class="form-group">
						<label for="area">Area:</label> <input type="text"
							class="form-control" id="area" name="area" required>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button type="submit" class="btn btn-primary">Add Schedule</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
