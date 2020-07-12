package com.kalyan.album.practice.service;

import org.springframework.stereotype.Service;

import com.kalyan.album.practice.beans.UserDetails;

@Service
public interface UserInformationService {

	public Boolean registerUser(UserDetails userInformation);

	public UserDetails userDetails(String userName);

	public UserDetails updateUserInformationWithAlbumId(UserDetails userInformation);

}
