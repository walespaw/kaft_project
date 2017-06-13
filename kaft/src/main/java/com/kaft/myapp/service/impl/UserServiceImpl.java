package com.kaft.myapp.service.impl;

import java.text.DateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaft.myapp.dao.UsersRepository;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.dto.UserDto;
import com.kaft.myapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepository usersRepository;

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
		logger.info("Updating the user " + userApp.getUserNick() + " at time "
				+ DateFormat.getInstance().format(System.currentTimeMillis()));
		// usersRepository.save(userApp);
	}

	public void delete(UserApp userApp) {
		logger.info("Deleting the user " + userApp.getUserNick() + " at time "
				+ DateFormat.getInstance().format(System.currentTimeMillis()));
		usersRepository.delete(userApp);
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
			tempDto.setName(temp.getName());
			tempDto.setSecndName(temp.getSecondName());
			tempDto.setLastName(temp.getLastName());
			tempDto.setEmaill(temp.getEmail());
			tempDto.setUserAddressess(temp.getUserAddress());
			return tempDto;
		}).collect(Collectors.toList());
		return resultList;
	}
	
	

}
