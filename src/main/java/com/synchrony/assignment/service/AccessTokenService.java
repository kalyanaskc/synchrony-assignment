package com.synchrony.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.synchrony.assignment.imgur.response.AccessToken;
import com.synchrony.assignment.util.Constants;

@Configuration
public class AccessTokenService {

	@Autowired
	private RestTemplate restTemplate;

	public AccessToken getAccessToken() {
		final String request = buidlFormRequest();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		final HttpEntity<String> httpEntity = new HttpEntity<String>(request, headers);
		final ResponseEntity<AccessToken> postForEntity = restTemplate.postForEntity(Constants.ENDPOINT_URL,
				httpEntity, AccessToken.class);
		System.out.println(postForEntity);
		return postForEntity.getBody();
	}

	private String buidlFormRequest() {
		final StringBuilder request = new StringBuilder();
		request.append("refresh_token=");
		request.append(Constants.REFRESH_TOKEN);
		request.append("&");
		request.append("client_id=");
		request.append(Constants.CLIENT_ID);
		request.append("&");
		request.append("client_secret=");
		request.append(Constants.CLIENT_SECRET);
		request.append("&");
		request.append("grant_type=refresh_token");
		return request.toString();
	}

}
