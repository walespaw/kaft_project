package com.kaft.myapp.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class UserRoleId implements Serializable{
	@ManyToOne
	private UserApp userApp;
	@ManyToOne
	private RoleApp role;
	
	public UserRoleId(){}
	
	public UserRoleId(UserApp userApp, RoleApp role) {
		this.userApp = userApp;
		this.role = role;
	}
	
	public UserApp getUserApp() {
		return userApp;
	}
	public void setUserApp(UserApp userApp) {
		this.userApp = userApp;
	}
	public RoleApp getRole() {
		return role;
	}
	public void setRole(RoleApp role) {
		this.role = role;
	}
	
}
