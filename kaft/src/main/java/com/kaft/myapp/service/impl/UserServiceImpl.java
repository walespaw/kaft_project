package com.kaft.myapp.service.impl;

import java.text.DateFormat;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kaft.myapp.dao.AddressRepository;
import com.kaft.myapp.dao.UserRoleRepository;
import com.kaft.myapp.dao.UsersRepository;
import com.kaft.myapp.model.UserAddress;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.UserRole;
import com.kaft.myapp.model.dto.UserDto;
import com.kaft.myapp.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private AddressRepository addresRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	

	// public static final Logger logger =
	// Logger.getLogger(UserServiceImpl.class);

	public void setUserRepositry(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	public void save(UserApp userApp) {
		usersRepository.save(userApp);

		logger.info("Saving the user at time " + DateFormat.getInstance().format(System.currentTimeMillis()));
	}

	public void update(UserApp userApp) {
		// do nothing for now
		logger.info("Updating the user with " +userApp.getId()+ " at time "
				+ DateFormat.getInstance().format(System.currentTimeMillis()));
		usersRepository.update(userApp.getId(), userApp.getUserNick(), userApp.getPassword(), userApp.getName(), userApp.getLastName(), userApp.getLastName(), userApp.getEmail());
	}

	public void delete(int id) {
		logger.info("Deleting the user with " + id + " at time "
				+ DateFormat.getInstance().format(System.currentTimeMillis()));
		usersRepository.delete(id);
	}

	public List<UserApp> findAll() {
		logger.info("Returning all user list at time " + DateFormat.getInstance().format(System.currentTimeMillis()));
		return usersRepository.findAll();
	}

	public List<UserApp> findByEmailContainingIgnoreCase(String mail) {
		logger.info("Search user by email containing = " + mail + " at time "
				+ DateFormat.getInstance().format(System.currentTimeMillis()));
		return usersRepository.findByEmailContainingIgnoreCase(mail);
	}

	public List<UserApp> getUserByNickOrName(String nick, String name) {
		logger.info("Get user/users by nick = " + nick + " or name = " + nick + " at time "
				+ DateFormat.getInstance().format(System.currentTimeMillis()));
		return usersRepository.getUserByNickOrName(nick, name);
	}

	public List<UserApp> findAllUsersWithActiveStatus() {
		List<UserApp> listOfAll = findAll();
		List<UserApp> result = listOfAll.stream().filter(user -> UserApp.UserStatus.ACTIVE.equals(user.getStatus())).collect(Collectors.toList()) ;
		return result;
	}

	@Override
	public List<UserDto> getAllUserDto() {
		List<UserApp> listToDto = findAll();
		List<UserDto> resultList = listToDto.stream().map(temp->{
			UserDto tempDto = new UserDto();
			tempDto.setId(temp.getId());
			tempDto.setUserNick(temp.getUserNick());
			tempDto.setPassword(temp.getPassword());
			tempDto.setName(temp.getName());
			tempDto.setSecndName(temp.getSecondName());
			tempDto.setLastName(temp.getLastName());
			tempDto.setEmaill(temp.getEmail());
			tempDto.setUserAddressess(temp.getUserAddress());
			return tempDto;
		}).collect(Collectors.toList());
		return resultList;
	}

	@Override
	public void delete(UserApp userApp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveUserAndAddress(UserApp user, UserAddress address) {
		usersRepository.save(user);
		addresRepository.save(address);
	}
	
	
	@Override
	public UserApp findByUserNick(String nick) {
		return usersRepository.findByUserNick(nick);
	}

	public List<UserRole> findUserRoleByUser(UserApp user) {
		return userRoleRepository.findByPkUserApp(user);
	}
	
	@Override
	public List<UserRole> findUserRoleById(int id) {
		// TODO Auto-generated method stub
		return usersRepository.findUserRolesById(id);
	}
	
	//Security
	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User buildUserForAuthentication(UserApp user, List<GrantedAuthority> authorities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		return null;
	}


}
