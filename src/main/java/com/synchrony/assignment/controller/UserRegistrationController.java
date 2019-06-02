package com.synchrony.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synchrony.assignment.beans.UserInformation;
import com.synchrony.assignment.service.UserInformationService;

@Controller
@RequestMapping("/user")
public class UserRegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private UserInformationService userInformationService;

	//@RequestMapping(name = "/register", method = RequestMethod.POST)
	@PostMapping(name = "/register")
	@ResponseBody
	public void registerUser(@RequestBody UserInformation userInformation) {
		userInformationService.registerUser(userInformation);
	}

}
