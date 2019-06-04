package com.synchrony.assignment.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.synchrony.assignment.album.response.AlbumResponse;
import com.synchrony.assignment.imgur.response.ImageCreationResponse;
import com.synchrony.assignment.util.Constants;

@Configuration
public class ImgurImageServiceImpl implements ImgurImageService {

	@Autowired
	private RestTemplate restTemplate;

	private final String albumCreationUrl = "https://api.imgur.com/3/upload";

	private final String albumUrl = "https://api.imgur.com/3/album/";

	@Autowired
	private AccessTokenService accessTokenService;

	@Override
	public ImageCreationResponse addImage(final String albumId, final MultipartFile file) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.add(Constants.AUTH_HEADER, Constants.BEARER + accessTokenService.getAccessToken().getAccessToken());
		Path tempFile = null;
		try {
			tempFile = Files.createTempFile(null, null);
			Files.write(tempFile, file.getBytes());
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final File fileToSend = tempFile.toFile();
		final MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		body.add("image", new FileSystemResource(fileToSend));
		body.add("album", albumId);
		final HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(body,
				headers);
		final ResponseEntity<ImageCreationResponse> postForEntity = restTemplate.postForEntity(albumCreationUrl,
				httpEntity, ImageCreationResponse.class);
		return postForEntity.getBody();
	}

	@Override
	public String deleteImage(final String albumDeleteId) {
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Client-ID " + Constants.CLIENT_ID);
		final HttpEntity<String> httpEntity = new HttpEntity<String>("",headers);
		restTemplate.exchange(albumUrl + albumDeleteId,HttpMethod.DELETE, httpEntity,Object.class);
		return "deleted successfully";
	}

	@Override
	public AlbumResponse viewImages(final String albumId) {
		final HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Client-ID " + Constants.CLIENT_ID);
		final HttpEntity<String> httpEntity = new HttpEntity<String>("",headers);
		final ResponseEntity<AlbumResponse> response = restTemplate.exchange(albumUrl + albumId ,
				HttpMethod.GET, httpEntity, AlbumResponse.class);
		return response.getBody();
	}

}
