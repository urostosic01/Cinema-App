package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the movie database table.
 * 
 */
@Entity
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMovie;

	private String desc;

	private int length;

	private String poster;

	private double rating;

	private String title;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	private Genre genre;

	//bi-directional many-to-one association to Projection
	@OneToMany(mappedBy="movie")
	private List<Projection> projections;

	public Movie() {
	}

	public int getIdMovie() {
		return this.idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getRating() {
		return this.rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<Projection> getProjections() {
		return this.projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public Projection addProjection(Projection projection) {
		getProjections().add(projection);
		projection.setMovie(this);

		return projection;
	}

	public Projection removeProjection(Projection projection) {
		getProjections().remove(projection);
		projection.setMovie(null);

		return projection;
	}

}