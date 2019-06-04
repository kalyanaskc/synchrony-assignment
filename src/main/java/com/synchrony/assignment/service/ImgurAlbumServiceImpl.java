package com.synchrony.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.synchrony.assignment.imgur.response.AlbumCreationResponse;
import com.synchrony.assignment.util.Constants;

@Configuration
public class ImgurAlbumServiceImpl implements ImgurAlbumService {

	@Autowired
	private RestTemplate restTemplate;

	private String albumCreationUrl = "https://api.imgur.com/3/album";

	@Autowired
	private AccessTokenService accessTokenService;

	@Override
	public AlbumCreationResponse createAlbum(String titleName, String description) {
		final String request = albumCreationRequest(titleName, description);
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.add(Constants.AUTH_HEADER, Constants.BEARER + accessTokenService.getAccessToken().getAccessToken());
		final HttpEntity<String> httpEntity = new HttpEntity<String>(request, headers);
		final ResponseEntity<AlbumCreationResponse> postForEntity = restTemplate.postForEntity(albumCreationUrl,
				httpEntity, AlbumCreationResponse.class);
		return postForEntity.getBody();
	}

	private String albumCreationRequest(String titleName, String description) {
		StringBuilder sb = new StringBuilder();
		sb.append("title=");
		sb.append(titleName);
		sb.append("&description=");
		sb.append(description);
		return sb.toString();
	}

	@Override
	public String deleteAlbum(String albumId) {
		return null;
	}

}
