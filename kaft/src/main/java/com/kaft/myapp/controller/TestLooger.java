package com.kaft.myapp.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kaft.myapp.model.UserAddress;
import com.kaft.myapp.model.UserApp;
import com.kaft.myapp.model.UserApp.UserStatus;
import com.kaft.myapp.model.UserRole;
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
	
	@RequestMapping(value="/allAppUsers", method=RequestMethod.GET)
	public ModelAndView viewForAllUsers(){
		List<UserApp> list = userService.findAll();
		
		return new ModelAndView("allAppUsers", "list", list);
	}
	
	@RequestMapping(value="/allDtoUsers", method=RequestMethod.GET)
	public String viewForDtoUsers(Model model){
		
		model.addAttribute("list", userService.getAllUserDto());
		
		return "allDtoUsers";
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(Model model){
		UserApp userThatFound = userService.findByUserNick("pawel");
		System.out.println(userThatFound.getEmail());
		
		List<UserRole> rolesThatFound = userService.findUserRoleByUser(userThatFound);
		rolesThatFound.forEach(item->System.out.println(item.getRole().getRoleName()));
		
		/*for(UserRole role: rolesThatFound){
			System.out.println(role.getRole().getRoleName());
		}*/
		
		List<UserRole> rolesFoundById = userService.findUserRoleById(5);
		
		rolesFoundById.forEach(item->System.out.println("By id:"+item.getRole().getRoleName()));
		
		model.addAttribute("testLogger", new String("Strona testowa"));
		
		return "test";
	}
	
}
