package com.kaft.myapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kaft.myapp.model.UserApp;

@Repository
public interface UsersRepository extends JpaRepository<UserApp, Integer> {
	
	//pobranie wszystkich użytkowników
	public List<UserApp> findAll();
	//pobranie po adresie email %mail%
	public List<UserApp> findByEmailContainingIgnoreCase(String mail);
	//pobranie wszystkich niz podana nazwa
	@Query("from UserApp u where u.userNick != ?1")
	public List<UserApp> diffThanUsedName(String usernick);
	//pobranie użytkownika o podanym loginie lub 
	@Query(value="select * from usersapp where usernick like '%?1%'or name like '%?2%'", nativeQuery = true )
	public List<UserApp> getUserByNickOrName(String nick, String name);
}
