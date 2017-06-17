package com.kaft.myapp.model.dto;

import com.kaft.myapp.model.UserAddress;
import com.kaft.myapp.model.UserApp;

public class UserAndAddressFormPassDto {
	private int Id;
	private String userNick;
	private String password;
	private String name;
	private String lastName;
	private String secondName;
	private String email;
	private UserApp.UserStatus status;
	private long addressId;
	private String country;
	private String city;
	private String zipCode;
	private String street;
	private int streetNumber;
	private int flatNumber;

	public UserAndAddressFormPassDto() {
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

	public UserApp.UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserApp.UserStatus status) {
		this.status = status;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public int getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(int flatNumber) {
		this.flatNumber = flatNumber;
	}
	
	public UserApp returnUserApp(){
		UserApp result = new UserApp();
		result.setName(this.name);
		result.setUserNick(this.userNick);
		result.setPassword(this.password);
		result.setLastName(this.lastName);
		result.setSecondName(this.secondName);
		result.setEmail(this.email);
		return result;
	}
	
	public UserAddress returnUserAddress(){
		UserAddress result = new UserAddress();
		result.setCity(this.city);
		result.setCountry(this.country);
		result.setZipCode(this.zipCode);
		result.setStreet(this.street);
		result.setStreetNumber(this.streetNumber);
		result.setFlatNumber(this.flatNumber);
		return result;
	}

}
