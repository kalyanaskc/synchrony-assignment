package com.synchrony.assignment.service;

import org.springframework.stereotype.Service;

import com.synchrony.assignment.beans.UserDetails;

@Service
public interface UserInformationService {

	public Boolean registerUser(UserDetails userInformation);

	public UserDetails userDetails(String userName);

	public UserDetails updateUserInformationWithAlbumId(UserDetails userInformation);

}
