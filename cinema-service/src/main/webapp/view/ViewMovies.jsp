<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies</title>
<link rel="stylesheet" href="../css/movies-style.css">

</head>
<body>

	<h1>Movies</h1>
	<div class="movie-list">

		<c:forEach var="movie" items="${allMovies}">
			<div class="movie">
				<form action="/Cinema/guest/getProjections" method="get">
					<img alt="movie-poster" src="${movie.poster}">
					<h2>${movie.title}</h2>
					<p>Length: ${movie.length} min</p>
					<p>Rating: ${movie.rating} /10</p>
					<p>Description: ${movie.desc}</p>
					<input type="hidden" name="idMovie" value="${movie.idMovie}">
					<button type="submit">View All Projections</button>
				</form>
			</div>
		</c:forEach>
	</div>

</body>
</html>