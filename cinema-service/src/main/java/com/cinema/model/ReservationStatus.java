package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the reservationstatus database table.
 * 
 */
@Entity
@NamedQuery(name="ReservationStatus.findAll", query="SELECT r FROM ReservationStatus r")
public class ReservationStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReservationStatus;

	private String statusName;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="reservationstatus")
	private List<Reservation> reservations;

	public ReservationStatus() {
	}

	public int getIdReservationStatus() {
		return this.idReservationStatus;
	}

	public void setIdReservationStatus(int idReservationStatus) {
		this.idReservationStatus = idReservationStatus;
	}

	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setReservationstatus(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setReservationstatus(null);

		return reservation;
	}

}