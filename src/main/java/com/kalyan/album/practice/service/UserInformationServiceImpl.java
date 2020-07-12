package com.kalyan.album.practice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalyan.album.practice.beans.UserDetails;
import com.kalyan.album.practice.repository.UserInformationRepository;

/**
 * Service class for user operations
 * */
@Service
public class UserInformationServiceImpl implements UserInformationService {

	@Autowired
	private UserInformationRepository userInformationRepository;

	@Override
	public Boolean registerUser(UserDetails userInformation) {
		userInformationRepository.save(userInformation);
		return true;
	}

	@Override
	public UserDetails userDetails(String userName) {
		return userInformationRepository.findByUserName(userName);
	}

	@Override
	public UserDetails updateUserInformationWithAlbumId(UserDetails userInformation) {
		return userInformationRepository.save(userInformation);
	}

}
