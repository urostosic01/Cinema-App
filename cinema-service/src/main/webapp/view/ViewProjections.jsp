<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projections</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f0f0f0;
}

h1 {
	text-align: center;
}

.projection-list {
	padding: 20px;
}

.projection {
	background-color: #fff;
	border-radius: 5px;
	padding: 20px;
	margin-bottom: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.projection h2 {
	font-size: 20px;
	margin-bottom: 10px;
}

.projection p {
	margin: 5px 0;
}

.reserve-button {
	display: block;
	width: 30%;
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

.reserve-button:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>Projections</h1>
	<c:forEach var="projection" items="${allProjections}">
		<div class="projection-list">
			<form action="">
				<div class="projection">
					<h2>Date and time: ${projection.dateTime}</h2>
					<h3>${projection.movie.title}</h3>
					<p>${projection.theatre.title}</p>
					<p>Capacity: ${projection.theatre.capacity}</p>
					<p>Price: ${projection.price} euro</p>
					<button class="reserve-button">Reserve</button>
				</div>
			</form>
		</div>

	</c:forEach>


</body>
</html>