package com.kaft.myapp.dao;

import java.util.List;

import com.kaft.myapp.model.UserApp;

public interface UsersRepository {
	
	void save(UserApp user);
	void update(UserApp user);
	void delete(UserApp user);
	//List<UserApp> getUsersById();
}
