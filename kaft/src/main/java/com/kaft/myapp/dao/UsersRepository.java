package com.kaft.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaft.myapp.model.UserApp;

@Repository
public interface UsersRepository extends JpaRepository<UserApp, Integer> {
	
	//pobranie wszystkich użytkowników
	public List<UserApp> findAllByOrderByIdAsc();
	//pobranie po adresie email %mail%
	public List<UserApp> findByEmailContainingIgnoreCase(String mail);
	
	
}
