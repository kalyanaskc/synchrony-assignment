package com.synchrony.assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.synchrony.assignment.beans.UserDetails;
import com.synchrony.assignment.service.UserInformationService;

@RestController
public class UserRegistrationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);

	@Autowired
	private UserInformationService userInformationService;

	/**
	 * Method for new user registration
	 * */
	@PostMapping(name = "/user/register")
	@ResponseBody
	public void registerUser(@RequestBody UserDetails userInformation) {
		LOGGER.info("Registering user : {}", userInformation);
		userInformationService.registerUser(userInformation);
	}

}
