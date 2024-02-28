package com.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinema.model.Projection;
import com.cinema.model.Movie;

public interface ProjectionRepository extends JpaRepository<Projection, Integer>{

	public List<Projection> findByMovie(Movie movie);
}
