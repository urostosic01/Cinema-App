package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReservation;

	@Temporal(TemporalType.DATE)
	private Date dateTimeRes;

	private int numberOfTickets;

	private double totalPrice;

	//bi-directional many-to-one association to Projection
	@ManyToOne
	private Projection projection;

	//bi-directional many-to-one association to ReservationStatus
	@ManyToOne
	private ReservationStatus reservationstatus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_idUser", referencedColumnName="idUser")
	private User user;

	public Reservation() {
	}

	public int getIdReservation() {
		return this.idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateTimeRes() {
		return this.dateTimeRes;
	}

	public void setDateTimeRes(Date dateTimeRes) {
		this.dateTimeRes = dateTimeRes;
	}

	public int getNumberOfTickets() {
		return this.numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Projection getProjection() {
		return this.projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public ReservationStatus getReservationstatus() {
		return this.reservationstatus;
	}

	public void setReservationstatus(ReservationStatus reservationstatus) {
		this.reservationstatus = reservationstatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}