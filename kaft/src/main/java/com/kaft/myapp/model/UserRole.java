package com.kaft.myapp.model;

import java.time.LocalDateTime;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "UserRole")
@AssociationOverrides({ @AssociationOverride(name = "pk.userApp", 
			joinColumns = @JoinColumn(name = "UserId")),
		@AssociationOverride(name = "pk.role", 
			joinColumns = @JoinColumn(name = "IdRole")) })
public class UserRole {
	
	@EmbeddedId
	private UserRoleId pk;
	@Column(name="RegistryDate")
	private LocalDateTime registryDateRole;
	@Column(name="GiveBy")
	private String giveBy;
	@Column(name="Active")
	private boolean active;
	
	public UserRole(){}
	
	public UserRole(UserRoleId pk, LocalDateTime registryDateRole, String giveBy, boolean active) {
		this.pk = pk;
		this.registryDateRole = registryDateRole;
		this.giveBy = giveBy;
		this.active = active;
	}
	
	public UserRoleId getPk() {
		return pk;
	}
	public void setPk(UserRoleId pk) {
		this.pk = pk;
	}
	//covered
	@Transient
	public UserApp getUserApp(){
		return getPk().getUserApp();
	}
	public void setUserApp(UserApp userApp){
		getPk().setUserApp(userApp);
	}
	//covered
	@Transient
	public RoleApp getRole(){
		return getPk().getRole();
	}
	public void setRole(RoleApp role){
		getPk().setRole(role);
	}
	public LocalDateTime getRegistryDateRole() {
		return registryDateRole;
	}
	public void setRegistryDateRole(LocalDateTime registryDateRole) {
		this.registryDateRole = registryDateRole;
	}
	public String getGiveBy() {
		return giveBy;
	}
	public void setGiveBy(String giveBy) {
		this.giveBy = giveBy;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}
