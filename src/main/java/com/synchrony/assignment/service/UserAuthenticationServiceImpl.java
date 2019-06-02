package com.synchrony.assignment.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synchrony.assignment.beans.UserInformation;
import com.synchrony.assignment.repository.UserInformationRepository;

import sun.misc.BASE64Decoder;

@Component
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Override
	public boolean isUserAuthenticated(String authorizationHeader) {
		return authenticateUser(authorizationHeader);
	}

	private Boolean authenticateUser(String authorizationHeader) {
		String[] authParts = authorizationHeader.split("\\s+");
		String userNamePassword;
		try {
			byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(authParts[1]);
			userNamePassword = new String(decodeBuffer);
			String[] split = userNamePassword.split(":");
			UserInformation userInformation = userInformationRepository.findByUserName(split[0]);
			return userInformation != null && userInformation.getPassword() != null
					&& userInformation.getPassword().equals(split[1]);
		} catch (IOException e) {
			return false;
		}

	}

	@Override
	public String getUserName(String authorizationHeader) {
		String[] authParts = authorizationHeader.split("\\s+");
		String userNamePassword;
		try {
			byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(authParts[1]);
			userNamePassword = new String(decodeBuffer);
			String[] split = userNamePassword.split(":");
			return split[0];
		} catch (IOException e) {
			return "";
		}
	}

}
