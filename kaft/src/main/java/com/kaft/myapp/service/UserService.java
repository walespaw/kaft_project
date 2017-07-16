package com.kaft.myapp.service;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.kaft.myapp.model.UserAddress;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.UserRole;
//import com.kaft.myapp.service.impl.UserServiceImpl;
import com.kaft.myapp.model.dto.UserDto;

public interface UserService {
	public static final Logger logger = Logger.getLogger(UserService.class);
	void save(UserApp userApp);
	void update(UserApp userApp);
	void delete(UserApp userApp);
	List<UserApp> findAll();
	List<UserApp> findByEmailContainingIgnoreCase(String mail);
	List<UserApp> getUserByNickOrName(String nick, String name);
	List<UserApp> findAllUsersWithActiveStatus();
	
	List<UserDto> getAllUserDto();
	void saveUserAndAddress(UserApp user, UserAddress address);
	
	UserApp findByUserNick(String nick);
	List<UserRole> findUserRoleByUser(UserApp user);
	List<UserRole> findUserRoleById(int id);
	
	//security
	UserDetails loadUserByUsername(String username);
	User buildUserForAuthentication(UserApp user, List<GrantedAuthority> authorities);
	List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles);
}
