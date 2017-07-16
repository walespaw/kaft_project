package com.kaft.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaft.myapp.model.RoleApp;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.UserRole;
import com.kaft.myapp.model.UserRoleId;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleId> {
	public List<UserRole> findAll();
	public List<UserRole> findByPkUserApp(UserApp user);
	/*
	public List<UserRole> findByPkUserApp(UserApp userApp);
	public List<UserRole> findByPkRole(RoleApp roleApp);*/
	}
