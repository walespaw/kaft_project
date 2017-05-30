package com.kaft.myapp.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.kaft.myapp.model.UserApp;
//import com.kaft.myapp.service.impl.UserServiceImpl;

public interface UserService {
	public static final Logger logger = Logger.getLogger(UserService.class);
	void save(UserApp userApp);
	void update(UserApp userApp);
	void delete(UserApp userApp);
	List<UserApp> findAll();
	List<UserApp> findByEmailContainingIgnoreCase(String mail);
	List<UserApp> getUserByNickOrName(String nick, String name);
	List<UserApp> findAllUsersWithActiveStatus();
}
