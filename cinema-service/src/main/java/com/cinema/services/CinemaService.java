package com.cinema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinema.model.Genre;
import com.cinema.model.Movie;
import com.cinema.model.Projection;
import com.cinema.repository.GenreRepository;
import com.cinema.repository.MovieRepository;
import com.cinema.repository.ProjectionRepository;

@Service
public class CinemaService {

	@Autowired
	GenreRepository genreRepo;
	
	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	ProjectionRepository projectionRepo;
	
	public List<Genre> findAllGenres() {
		return genreRepo.findAll();
	}

	public List<Movie> findAllMovies() {
		return movieRepo.findAll();
	}

	public List<Projection> findAllProjection(Integer idMovie) {
		Optional<Movie> movie = movieRepo.findById(idMovie);
		if(movie.isPresent()) {
			return projectionRepo.findByMovie(movie.get());	
		} else {
			System.err.println("NE POSTOJE PROJEKCIJE ZA FILM");
			return null;
		}
		
	}
}
