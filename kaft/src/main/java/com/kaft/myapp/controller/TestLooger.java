package com.kaft.myapp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kaft.myapp.service.UserService;

@Controller
public class TestLooger {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(Model model){
		
		userService.save(null);
		return "test";
	}
}
