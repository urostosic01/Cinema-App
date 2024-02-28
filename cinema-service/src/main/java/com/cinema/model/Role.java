package com.cinema.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;

	private String roleName;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userroles;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserRole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(List<UserRole> userroles) {
		this.userroles = userroles;
	}

	public UserRole addUserrole(UserRole userrole) {
		getUserroles().add(userrole);
		userrole.setRole(this);

		return userrole;
	}

	public UserRole removeUserrole(UserRole userrole) {
		getUserroles().remove(userrole);
		userrole.setRole(null);

		return userrole;
	}

}