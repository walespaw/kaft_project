package com.kaft.myapp.service.impl;

import java.text.DateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaft.myapp.dao.UsersRepository;
import com.kaft.myapp.model.UserApp;
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
		// usersRepository.save(userApp);

		logger.info("Saving the user at time " + DateFormat.getInstance().format(System.currentTimeMillis()));
	}

	public void update(UserApp userApp) {
		// do nothing for ow
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

}
