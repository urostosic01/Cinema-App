package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the projection database table.
 * 
 */
@Entity
@NamedQuery(name="Projection.findAll", query="SELECT p FROM Projection p")
public class Projection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idProjection;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	private double price;

	//bi-directional many-to-one association to Movie
	@ManyToOne
	private Movie movie;

	//bi-directional many-to-one association to Theatre
	@ManyToOne
	private Theatre theatre;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="projection")
	private List<Reservation> reservations;

	public Projection() {
	}

	public int getIdProjection() {
		return this.idProjection;
	}

	public void setIdProjection(int idProjection) {
		this.idProjection = idProjection;
	}

	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theatre getTheatre() {
		return this.theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setProjection(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setProjection(null);

		return reservation;
	}

}