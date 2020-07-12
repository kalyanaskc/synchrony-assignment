package com.kalyan.album.practice.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kalyan.album.practice.album.response.AlbumResponse;
import com.kalyan.album.practice.album.response.UserResponse;
import com.kalyan.album.practice.beans.UserDetails;
import com.kalyan.album.practice.imgur.response.AlbumCreationResponse;
import com.kalyan.album.practice.imgur.response.ImageCreationResponse;
import com.kalyan.album.practice.service.ImgurAlbumService;
import com.kalyan.album.practice.service.ImgurImageService;
import com.kalyan.album.practice.service.UserAuthenticationService;
import com.kalyan.album.practice.service.UserInformationService;

/**
 * Controller class for album operations
 * */
@RestController
public class AlbumController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlbumController.class);
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
		LOGGER.info("uploading image");
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
		LOGGER.info("viewing album");
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
		LOGGER.info("Deleting album");
		if (!userAuthenticationService.isUserAuthenticated(authorization)) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		final String userName = userAuthenticationService.getUserName(authorization);
		final UserDetails userDetails = userInformationService.userDetails(userName);
		imgurImageService.deleteImage(userDetails.getDeleteAlbumId());
		return new ResponseEntity<String>("Album Deleted Successfully", HttpStatus.OK);
	}

}
