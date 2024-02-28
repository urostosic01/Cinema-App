package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the theatre database table.
 * 
 */
@Entity
@NamedQuery(name="Theatre.findAll", query="SELECT t FROM Theatre t")
public class Theatre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTheatre;

	private int capacity;

	private String title;

	//bi-directional many-to-one association to Projection
	@OneToMany(mappedBy="theatre")
	private List<Projection> projections;

	//bi-directional many-to-one association to TheatreType
	@ManyToOne
	private TheatreType theatretype;

	public Theatre() {
	}

	public int getIdTheatre() {
		return this.idTheatre;
	}

	public void setIdTheatre(int idTheatre) {
		this.idTheatre = idTheatre;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Projection> getProjections() {
		return this.projections;
	}

	public void setProjections(List<Projection> projections) {
		this.projections = projections;
	}

	public Projection addProjection(Projection projection) {
		getProjections().add(projection);
		projection.setTheatre(this);

		return projection;
	}

	public Projection removeProjection(Projection projection) {
		getProjections().remove(projection);
		projection.setTheatre(null);

		return projection;
	}

	public TheatreType getTheatretype() {
		return this.theatretype;
	}

	public void setTheatretype(TheatreType theatretype) {
		this.theatretype = theatretype;
	}

}