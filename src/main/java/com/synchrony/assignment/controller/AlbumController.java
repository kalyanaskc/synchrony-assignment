package com.synchrony.assignment.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.assignment.album.response.AlbumResponse;
import com.synchrony.assignment.album.response.UserResponse;
import com.synchrony.assignment.beans.UserDetails;
import com.synchrony.assignment.imgur.response.AlbumCreationResponse;
import com.synchrony.assignment.imgur.response.ImageCreationResponse;
import com.synchrony.assignment.service.ImgurAlbumService;
import com.synchrony.assignment.service.ImgurImageService;
import com.synchrony.assignment.service.UserAuthenticationService;
import com.synchrony.assignment.service.UserInformationService;

/**
 * Controller class for album operations
 * */
@RestController
public class AlbumController {

	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@Autowired
	private UserInformationService userInformationService;

	@Autowired
	private ImgurAlbumService imgurAlbumService;

	@Autowired
	private ImgurImageService imgurImageService;

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	@ResponseStatus
	public ResponseEntity<ImageCreationResponse> uploadImage(@RequestHeader("authorization") final String authorization,
			@RequestParam("file") final MultipartFile file) throws IOException {
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		final String userName = userAuthenticationService.getUserName(authorization);
		String albumId = "";
		final UserDetails userDetails = userInformationService.userDetails(userName);
		if (userDetails != null && userDetails.getAlbumId() != null) {
			albumId = userDetails.getAlbumId();
		} else {
			final AlbumCreationResponse createAlbum = imgurAlbumService.createAlbum(userName, userName + " Album");
			albumId = createAlbum.getData().getId();
			userDetails.setAlbumId(albumId);
			userDetails.setDeleteAlbumId(createAlbum.getData().getDeletehash());
			userInformationService.updateUserInformationWithAlbumId(userDetails);
		}

		final ImageCreationResponse addImage = imgurImageService.addImage(albumId, file);
		return new ResponseEntity<ImageCreationResponse>(addImage, HttpStatus.OK);
	}

	@RequestMapping(value = "/album", method = RequestMethod.GET)
	@ResponseStatus
	public ResponseEntity<UserResponse> viewAlbum(@RequestHeader("authorization") final String authorization) {
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		final String userName = userAuthenticationService.getUserName(authorization);
		final UserDetails userDetails = userInformationService.userDetails(userName);
		final AlbumResponse viewImages = imgurImageService.viewImages(userDetails.getAlbumId());
		UserResponse userResponse = new UserResponse();
		userDetails.setPassword("**********");
		userResponse.setAlbumResponse(viewImages);
		userResponse.setUserInformation(userDetails);
		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/album", method = RequestMethod.DELETE)
	@ResponseStatus
	public ResponseEntity<String> deleteAlbum(@RequestHeader("authorization") final String authorization) {
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		final String userName = userAuthenticationService.getUserName(authorization);
		final UserDetails userDetails = userInformationService.userDetails(userName);
		imgurImageService.deleteImage(userDetails.getDeleteAlbumId());
		return new ResponseEntity<String>("Album Deleted Successfully", HttpStatus.OK);
	}

}
