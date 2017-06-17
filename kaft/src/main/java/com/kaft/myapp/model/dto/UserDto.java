package com.kaft.myapp.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.kaft.myapp.model.UserAddress;

public class UserDto{
	private int Id;
	private String userNick;
	private String password;
	private String name;
	private String lastName;
	private String secndName;
	private String emaill;
	private Set<UserAddress> userAddressess = new HashSet<>(0);

	public UserDto() {}

	public UserDto(int id, String password, String userNick, String name, String lastName, String secndName, String emaill,
			Set<UserAddress> userAddressess) {
		super();
		Id = id;
		this.userNick = userNick;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.secndName = secndName;
		this.emaill = emaill;
		this.userAddressess = userAddressess;
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
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getSecndName() {
		return secndName;
	}

	public void setSecndName(String secndName) {
		this.secndName = secndName;
	}

	public String getEmaill() {
		return emaill;
	}

	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}

	public Set<UserAddress> getUserAddressess() {
		return userAddressess;
	}

	public void setUserAddressess(Set<UserAddress> userAddressess) {
		this.userAddressess = userAddressess;
	}

}
