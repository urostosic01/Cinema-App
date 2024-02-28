package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUser;

	private String email;

	private String firstName;

	private String lastName;

	private String password;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="user")
	private List<Reservation> reservations;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userroles;

	public User() {
	}
	
	public int getIdUser() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Reservation addReservation(Reservation reservation) {
		getReservations().add(reservation);
		reservation.setUser(this);

		return reservation;
	}

	public Reservation removeReservation(Reservation reservation) {
		getReservations().remove(reservation);
		reservation.setUser(null);

		return reservation;
	}

	public List<UserRole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(List<UserRole> userroles) {
		this.userroles = userroles;
	}

	public UserRole addUserrole(UserRole userrole) {
		getUserroles().add(userrole);
		userrole.setUser(this);

		return userrole;
	}

	public UserRole removeUserrole(UserRole userrole) {
		getUserroles().remove(userrole);
		userrole.setUser(null);

		return userrole;
	}

	

}