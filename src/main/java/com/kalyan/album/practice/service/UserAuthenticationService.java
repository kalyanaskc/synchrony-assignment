package com.kalyan.album.practice.service;

import org.springframework.stereotype.Service;

@Service
public interface UserAuthenticationService {

	public boolean isUserAuthenticated(String authorizationCode);

	public String getUserName(String authorizationCode);
	
}
