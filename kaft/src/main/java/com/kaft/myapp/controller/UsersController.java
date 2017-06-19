package com.kaft.myapp.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.javafaker.Faker;
import com.kaft.myapp.model.UserAddress;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.UserApp.UserStatus;
import com.kaft.myapp.model.dto.UserAndAddressFormPassDto;
import com.kaft.myapp.model.dto.UserDto;
import com.kaft.myapp.service.UserService;

@Controller
public class UsersController {

	private static final Logger logger = Logger.getLogger(UsersController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String viewAllUsers(Model model) {

		model.addAttribute("users", userService.findAll());

		return "users";
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") UserAndAddressFormPassDto user, BindingResult result, Model model) {
		if (result.hasErrors()) {

			// modelToPick(model)
			return "registerForm";
		} else {
			if (user.getAddressId()==0) {
				logger.info("Add new user");
				UserAddress addressToSet = user.returnUserAddress();
				UserApp userToSet = user.returnUserApp();
				
				addressToSet.setUserApp(userToSet);
				Set<UserAddress> tempSet = new HashSet<>();
				tempSet.add(addressToSet);
				userToSet.setUserAddress(tempSet);
								
				userService.saveUserAndAddress(userToSet, addressToSet);
			} else {
				logger.info("Updated user with id: " + user.getId());
				//userService.update(user);
			}
		}

		return "redirect:/users";
	}

	@RequestMapping(value="/registerUser", method = RequestMethod.GET)
	public String showAddForm(Model model){
		
		Faker fakeData = new Faker();
		
		logger.info(fakeData.name().fullName());
		
		
		UserAndAddressFormPassDto userToFill = new UserAndAddressFormPassDto();
		userToFill.setUserNick(fakeData.name().username());
		userToFill.setPassword(String.valueOf(new Random().nextInt(10)));
		userToFill.setName(fakeData.name().firstName());
		userToFill.setLastName(fakeData.name().lastName());
		userToFill.setSecondName(fakeData.gameOfThrones().dragon());
		userToFill.setEmail(fakeData.name().firstName().toLowerCase()+fakeData.name().lastName().toLowerCase()+"@gmail.com");
		userToFill.setStatus(UserStatus.ACTIVE);
		userToFill.setCountry(fakeData.address().country());
		userToFill.setCity(fakeData.address().city());
		userToFill.setZipCode(fakeData.address().zipCode().toString());
		userToFill.setStreet(fakeData.address().streetName());
		userToFill.setStreetNumber(5);
		userToFill.setFlatNumber(1);
	
		model.addAttribute("userForm", userToFill);
		return "registerForm";
	}
	
	@RequestMapping(value="/usersJson")
	@ResponseBody
	public List<UserDto> convertToJson(){
		List<UserDto> result = userService.getAllUserDto();
		
		return result;
	}

}
