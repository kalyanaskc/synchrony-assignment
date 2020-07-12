package com.kalyan.album.practice.imgur.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "access_token", "expires_in", "token_type", "scope", "refresh_token", "account_id",
		"account_username" })
public class AccessToken {

	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private Integer expiresIn;
	@JsonProperty("token_type")
	private String tokenType;
	@JsonProperty("scope")
	private String scope;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("account_id")
	private Integer accountId;
	@JsonProperty("account_username")
	private String accountUsername;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("access_token")
	public String getAccessToken() {
		return accessToken;
	}

	@JsonProperty("access_token")
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@JsonProperty("expires_in")
	public Integer getExpiresIn() {
		return expiresIn;
	}

	@JsonProperty("expires_in")
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}

	@JsonProperty("token_type")
	public String getTokenType() {
		return tokenType;
	}

	@JsonProperty("token_type")
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	@JsonProperty("scope")
	public String getScope() {
		return scope;
	}

	@JsonProperty("scope")
	public void setScope(String scope) {
		this.scope = scope;
	}

	@JsonProperty("refresh_token")
	public String getRefreshToken() {
		return refreshToken;
	}

	@JsonProperty("refresh_token")
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	@JsonProperty("account_id")
	public Integer getAccountId() {
		return accountId;
	}

	@JsonProperty("account_id")
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	@JsonProperty("account_username")
	public String getAccountUsername() {
		return accountUsername;
	}

	@JsonProperty("account_username")
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", expiresIn=" + expiresIn + ", tokenType=" + tokenType
				+ ", scope=" + scope + ", refreshToken=" + refreshToken + ", accountId=" + accountId
				+ ", accountUsername=" + accountUsername + ", additionalProperties=" + additionalProperties + "]";
	}

	
}