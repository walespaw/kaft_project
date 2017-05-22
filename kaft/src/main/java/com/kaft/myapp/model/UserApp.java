package com.kaft.myapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UsersApp")
public class UserApp implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "UserId", nullable = false)
	public int Id;
	@Column(name = "UserNick", nullable = false)
	private String userNick;
	@Column(name = "Name")
	private String name;
	@Column(name = "LastName")
	private String lastName;
	@Column(name = "SecondName")
	private String secondName;
	@Column(name = "Email")
	private String email;
	
	public enum UserStatus{INACTIVE, ACTIVE}
	
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="userApp")
	private Set<UserAddress> userAddress = new HashSet<UserAddress>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.userApp", cascade = CascadeType.ALL)
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public UserApp(){}
	
	public UserApp(String userNick, String name, String lastName, String secondName, String email, UserStatus status){
		this.userNick = userNick;
		this.name = name;
		this.lastName = lastName;
		this.secondName = secondName;
		this.email = email;
		
		this.status = status;
	}

	public UserApp(String userNick, String name, String lastName, String secondName, String email,
			Set<UserAddress> userAddress, Set<UserRole> userRoles, UserStatus status) {
				
		this.userNick = userNick;
		this.name = name;
		this.lastName = lastName;
		this.secondName = secondName;
		this.email = email;
		this.userAddress = userAddress;
		this.userRoles = userRoles;
		this.status = status;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Set<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

}
