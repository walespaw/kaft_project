package com.kaft.myapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "UserAddress")
public class UserAddress implements Serializable {
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AddressId", unique=true, nullable=false)
	private long addressId;
	@Column(name = "Country")
	private String country;
	@Column(name = "City")
	private String city;
	@Column(name = "ZipCode")
	private String zipCode;
	@Column(name = "Street")
	private String street;
	@Column(name = "StreetNumber")
	private int streetNumber;
	@Column(name = "FlatNumber")
	private int flatNumber;
	//
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", nullable = false)
	private UserApp userApp;
	
	public UserAddress(){}

	public UserAddress(String country, String city, String zipCode, String street, int streetNumber, int flatNumber,
			UserApp userApp) {
		super();
		this.country = country;
		this.city = city;
		this.zipCode = zipCode;
		this.street = street;
		this.streetNumber = streetNumber;
		this.flatNumber = flatNumber;
		this.userApp = userApp;
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

	public UserApp getUserApp() {
		return userApp;
	}

	public void setUserApp(UserApp userApp) {
		this.userApp = userApp;
	}
}
