package com.synchrony.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.synchrony.assignment.beans.UserInformation;
import com.synchrony.assignment.repository.UserInformationRepository;

@Component
public class UserInformationServiceImpl implements UserInformationService {

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Override
	public Boolean registerUser(UserInformation userInformation) {
		userInformationRepository.save(userInformation);
		return true;
	}

	@Override
	public UserInformation userDetails(String userName) {
		return userInformationRepository.findByUserName(userName);
	}

	@Override
	public UserInformation updateUserInformationWithAlbumId(UserInformation userInformation) {
		return userInformationRepository.save(userInformation);
	}

}
