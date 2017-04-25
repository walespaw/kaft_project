package com.kaft.myapp.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;



@Entity
public class UserRole {
	@ForeignKey
	private long idUser;
	private long idRole;
	private LocalDateTime registryDateRole;
	private String giveBy;
	private boolean active;
	
}
