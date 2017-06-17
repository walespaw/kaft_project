package com.kaft.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaft.myapp.model.UserAddress;

public interface AddressRepository extends JpaRepository<UserAddress, Integer>{
	public List<UserAddress> findAll();
}
