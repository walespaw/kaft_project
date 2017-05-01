package com.kaft.myapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="RoleApp")
public class RoleApp {
	@Id
	@GeneratedValue
	@Column(name="IdRole")
	private long idRole;
	@Column(name="RoleName")
	private String roleName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="pk.role")
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);
	
	
	public RoleApp(){}

	public RoleApp(String roleName) {
		this.roleName = roleName;
	}

	public long getIdRole() {
		return idRole;
	}

	public void setIdRole(long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
}
