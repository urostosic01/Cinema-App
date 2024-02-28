package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the genre database table.
 * 
 */
@Entity
@NamedQuery(name="Genre.findAll", query="SELECT g FROM Genre g")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGenre;

	private String genreName;

	//bi-directional many-to-one association to Movie
	@JsonIgnore
	@OneToMany(mappedBy="genre")
	private List<Movie> movies;

	public Genre() {
	}

	public int getIdGenre() {
		return this.idGenre;
	}

	public void setIdGenre(int idGenre) {
		this.idGenre = idGenre;
	}

	public String getGenreName() {
		return this.genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<Movie> getMovies() {
		return this.movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Movie addMovy(Movie movy) {
		getMovies().add(movy);
		movy.setGenre(this);

		return movy;
	}

	public Movie removeMovy(Movie movy) {
		getMovies().remove(movy);
		movy.setGenre(null);

		return movy;
	}

}