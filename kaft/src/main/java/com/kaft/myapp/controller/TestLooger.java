package com.kaft.myapp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kaft.myapp.model.UserAddress;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.UserApp.UserStatus;
import com.kaft.myapp.service.UserService;

@Controller
public class TestLooger {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/activeUsers", method=RequestMethod.GET)
	public ModelAndView getListOfUsers(){
		//ModelAndView model = new ModelAndView("activeUsers");
		List<UserApp> list = userService.findAllUsersWithActiveStatus();
		System.out.println(list.size());
		System.out.println(System.getProperty("catalina.base"));
		System.out.println(System.getProperty("user.home"));
		list.stream().map(user-> user.getName()).forEach(System.out::println);;
		
		return new ModelAndView("activeUsers","list", list);
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(Model model){
		
		//UserApp userApp = new UserApp();
		
		model.addAttribute("testLogger", new String("Strona testowa"));
		//userService.update(null);
		return "test";
	}
	
	/*
	userApp.setName("Paweł");
	userApp.setUserNick("pawel");
	userApp.setLastName("Gaweł");
	userApp.setSecondName("Ga");
	userApp.setEmail("pawel@test.pl");
	userApp.setStatus(UserStatus.ACTIVE);
	
	UserAddress address = new UserAddress("Poland", "abc", "27-415","def", 12, 0, userApp);
	Set<UserAddress> addressSet = new HashSet<UserAddress>();
	addressSet.add(address);
	
	userApp.setUserAddress(addressSet);*/
	/*userApp.setName("Marcin");
	userApp.setUserNick("marcin");
	userApp.setLastName("");
	userApp.setSecondName("Ga");
	userApp.setEmail("marcin@test.pl");
	userApp.setStatus(UserStatus.ACTIVE);
	
	UserAddress address = new UserAddress("Poland", "abc", "12-345","Abc", 12, 0, userApp);
	Set<UserAddress> addressSet = new HashSet<UserAddress>();
	addressSet.add(address);
	
	userApp.setUserAddress(addressSet);*/
	/*userApp.setName("Michał");
	userApp.setUserNick("michal");
	userApp.setLastName("Pałaszkiewicz");
	userApp.setSecondName("Am");
	userApp.setEmail("michal@test.pl");
	userApp.setStatus(UserStatus.ACTIVE);
	
	UserAddress address = new UserAddress("Poland", "abc", "27-564","Poznan", 12, 0, userApp);
	Set<UserAddress> addressSet = new HashSet<UserAddress>();
	addressSet.add(address);
	
	userApp.setUserAddress(addressSet);
	userService.save(userApp);*/
}
