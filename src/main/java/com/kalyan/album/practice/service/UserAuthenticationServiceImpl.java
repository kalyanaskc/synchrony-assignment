package com.kalyan.album.practice.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.album.practice.beans.UserDetails;
import com.kalyan.album.practice.repository.UserInformationRepository;

import java.util.Base64;
/**
 * Service class for user authentication operations
 */
@Service
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
		//byte[] decodeBuffer = new Base64.Decoder.decodeBuffer(authParts[1]);
		byte[] decodeBuffer = Base64.getDecoder().decode(authParts[1]);
		userNamePassword = new String(decodeBuffer);
		String[] split = userNamePassword.split(":");
		UserDetails userInformation = userInformationRepository.findByUserName(split[0]);
		return userInformation != null && userInformation.getPassword() != null
				&& userInformation.getPassword().equals(split[1]);
	}

	@Override
	public String getUserName(String authorizationHeader) {
		String[] authParts = authorizationHeader.split("\\s+");
		String userNamePassword;
		//byte[] decodeBuffer = new BASE64Decoder().decodeBuffer(authParts[1]);
		byte[] decodeBuffer = Base64.getDecoder().decode(authParts[1]);
		userNamePassword = new String(decodeBuffer);
		String[] split = userNamePassword.split(":");
		return split[0];
	}

}
