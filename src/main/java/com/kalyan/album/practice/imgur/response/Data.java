package com.kalyan.album.practice.imgur.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "deletehash" })
public class Data {

	@JsonProperty("id")
	private String id;
	@JsonProperty("deletehash")
	private String deletehash;

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("deletehash")
	public String getDeletehash() {
		return deletehash;
	}

	@JsonProperty("deletehash")
	public void setDeletehash(String deletehash) {
		this.deletehash = deletehash;
	}
}
