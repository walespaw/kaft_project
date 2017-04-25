package com.kaft.myapp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	//Set for @ManyToMany
	

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "UserAddress")
	private List<UserAddress> userAddress;

	public UserApp(int id, String userNick, String name, String lastName, String secondName,
			List<UserAddress> userAddress) {
		super();
		Id = id;
		this.userNick = userNick;
		this.name = name;
		this.lastName = lastName;
		this.secondName = secondName;
		this.userAddress = userAddress;
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

	public List<UserAddress> getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(List<UserAddress> userAddress) {
		this.userAddress = userAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
