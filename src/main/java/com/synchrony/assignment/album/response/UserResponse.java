package com.synchrony.assignment.album.response;

import com.synchrony.assignment.beans.UserInformation;

public class UserResponse {
	private UserInformation userInformation;

	private AlbumResponse albumResponse;

	public UserInformation getUserInformation() {
		return userInformation;
	}

	public void setUserInformation(UserInformation userInformation) {
		this.userInformation = userInformation;
	}

	public AlbumResponse getAlbumResponse() {
		return albumResponse;
	}

	public void setAlbumResponse(AlbumResponse albumResponse) {
		this.albumResponse = albumResponse;
	}

}
