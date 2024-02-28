package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the theatretype database table.
 * 
 */
@Entity
@NamedQuery(name="TheatreType.findAll", query="SELECT t FROM TheatreType t")
public class TheatreType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTheatreType;

	private String typeName;

	//bi-directional many-to-one association to Theatre
	@OneToMany(mappedBy="theatretype")
	private List<Theatre> theatres;

	public TheatreType() {
	}

	public int getIdTheatreType() {
		return this.idTheatreType;
	}

	public void setIdTheatreType(int idTheatreType) {
		this.idTheatreType = idTheatreType;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Theatre> getTheatres() {
		return this.theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

	public Theatre addTheatre(Theatre theatre) {
		getTheatres().add(theatre);
		theatre.setTheatretype(this);

		return theatre;
	}

	public Theatre removeTheatre(Theatre theatre) {
		getTheatres().remove(theatre);
		theatre.setTheatretype(null);

		return theatre;
	}

}