package com.kaft.myapp.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Test")
public class Test {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="user_name")
	private String user_name;
	
	public Test(){
		//to do
	}
	
	public Test(int id, String user) {
		super();
		//this.id = id;
		this.user_name = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser() {
		return user_name;
	}
	public void setUser(String user) {
		this.user_name = user;
	}
	
}
